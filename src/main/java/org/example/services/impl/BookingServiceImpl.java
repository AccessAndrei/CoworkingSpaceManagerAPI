package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.dto.BookingDTO;
import org.example.dto.ResidentDTO;
import org.example.dto.SubscriptionPlanDTO;
import org.example.dto.WorkplaceDTO;
import org.example.entities.BookingEntity;
import org.example.entities.ResidentEntity;
import org.example.entities.WorkplaceEntity;
import org.example.repositories.BookingRepository;
import org.example.repositories.ResidentRepository;
import org.example.repositories.WorkplaceRepository;
import org.example.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final WorkplaceRepository workplaceRepository;
    private final BookingRepository bookingRepository;
    private final ResidentRepository residentRepository;

    @Autowired
    public BookingServiceImpl(WorkplaceRepository workplaceRepository, BookingRepository bookingRepository, ResidentRepository residentRepository) {
        this.workplaceRepository = workplaceRepository;
        this.bookingRepository = bookingRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    @Transactional
    public BookingDTO bookWorkplace(Integer residentId, Integer workplaceId, LocalDateTime startTime, LocalDateTime endTime) {
        List<BookingEntity> existingBookings = bookingRepository.findBookingsByWorkplaceIdAndTimeRange(workplaceId, startTime, endTime);
        if (!existingBookings.isEmpty()) {
            throw new EntityNotFoundException("Workplace is not available");
        }
        ResidentEntity resident = residentRepository.findById(residentId).orElseThrow(() -> new EntityNotFoundException("Resident not found"));
        WorkplaceEntity workplace = workplaceRepository.findById(workplaceId).orElseThrow(() -> new EntityNotFoundException("Workplace not found"));
        BookingEntity newBooking = new BookingEntity(startTime, endTime, resident, workplace, null);
        bookingRepository.save(newBooking);
        return new BookingDTO(newBooking.getStartTime(), newBooking.getEndTime(), new ResidentDTO(residentId, resident.getName(), resident.getEmail(), new SubscriptionPlanDTO(resident.getSubscriptionPlan().getId(), resident.getSubscriptionPlan().getName(), resident.getSubscriptionPlan().getPrice())), new WorkplaceDTO(workplace.getId(), workplace.getName(), true), null);

    }

}