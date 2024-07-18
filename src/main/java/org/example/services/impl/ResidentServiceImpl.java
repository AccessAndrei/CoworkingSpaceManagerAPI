package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.ResidentDTO;
import org.example.dto.SubscriptionPlanDTO;
import org.example.entities.BookingEntity;
import org.example.entities.ResidentEntity;
import org.example.entities.SubscriptionPlanEntity;
import org.example.repositories.BookingRepository;
import org.example.repositories.ResidentRepository;
import org.example.repositories.SubscriptionPlanRepository;
import org.example.services.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    @Transactional
    public ResidentDTO checkAndUpdateSubscription() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusMonths(1);
        List<BookingEntity> bookingsLastMonth = bookingRepository.findAllByBookingDateBetween(oneMonthAgo, now);
        Map<ResidentEntity, Long> residentBookingCounts = bookingsLastMonth.stream()
                .collect(Collectors.groupingBy(BookingEntity::getResident, Collectors.counting()));
        Map.Entry<ResidentEntity, Long> maxEntry = residentBookingCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new EntityNotFoundException("No bookings found for any resident in the last month"));

        ResidentEntity topResident = maxEntry.getKey();
        long bookingCount = maxEntry.getValue();
        System.out.println("Резидент с наибольшим количеством бронирований: " + topResident.getName() + " с " + bookingCount + " бронированиями.");
        if (bookingCount > 1) {
            SubscriptionPlanEntity currentPlan = topResident.getSubscriptionPlan();
            SubscriptionPlanEntity higherPlan = subscriptionPlanRepository.findNextHigherPlan(currentPlan.getId());

            if (higherPlan != null) {
                topResident.setSubscriptionPlan(higherPlan);
                residentRepository.save(topResident);
                System.out.println("Резиденту предложен новый план: " + higherPlan.getName() + " за те же деньги.");
            }
        }

        return new ResidentDTO(topResident.getId(), topResident.getName(), topResident.getEmail(),
                new SubscriptionPlanDTO(topResident.getSubscriptionPlan().getId(),
                        topResident.getSubscriptionPlan().getName(),
                        topResident.getSubscriptionPlan().getPrice()));
    }
}