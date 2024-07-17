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

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    public ResidentDTO checkAndUpdateSubscription(int residentId) {
        ResidentEntity resident = residentRepository.findById(residentId).orElseThrow(() -> new EntityNotFoundException("Workplace not found"));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneMonthAgo = now.minusMonths(1);

        List<BookingEntity> bookingsLastMonth = bookingRepository.findBookingsByResidentIdAndTimeRange(residentId, oneMonthAgo, now);
        System.out.println("Количество бронирований за последний месяц: " + bookingsLastMonth.size());
        if (bookingsLastMonth.size() > 2) {
            System.out.println("Резидент сделал более 10 бронирований за последний месяц.");
            SubscriptionPlanEntity currentPlan = resident.getSubscriptionPlan();
            SubscriptionPlanEntity higherPlan = subscriptionPlanRepository.findNextHigherPlan(currentPlan.getId());

            if (higherPlan != null) {
                resident.setSubscriptionPlan(higherPlan);
                residentRepository.save(resident);
                System.out.println("Резиденту предложен новый план: " + higherPlan.getName() + " за те же деньги.");
            }

        }
        return new ResidentDTO(resident.getId(), resident.getName(), resident.getEmail(), new SubscriptionPlanDTO(resident.getSubscriptionPlan().getId(), resident.getSubscriptionPlan().getName(), resident.getSubscriptionPlan().getPrice()));
    }
}