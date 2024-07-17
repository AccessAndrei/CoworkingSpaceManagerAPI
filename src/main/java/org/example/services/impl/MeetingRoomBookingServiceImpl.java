package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.dto.BookingDTO;
import org.example.dto.MeetingRoomDTO;
import org.example.dto.ResidentDTO;
import org.example.dto.SubscriptionPlanDTO;
import org.example.entities.BookingEntity;
import org.example.entities.MeetingRoomEntity;
import org.example.entities.ResidentEntity;
import org.example.repositories.BookingRepository;
import org.example.repositories.MeetingRoomRepository;
import org.example.repositories.ResidentRepository;
import org.example.services.MeetingRoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeetingRoomBookingServiceImpl implements MeetingRoomBookingService {

    private final MeetingRoomRepository meetingRoomRepository;
    private final BookingRepository bookingRepository;
    private final ResidentRepository residentRepository;

    @Autowired
    public MeetingRoomBookingServiceImpl(MeetingRoomRepository meetingRoomRepository, BookingRepository bookingRepository, ResidentRepository residentRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
        this.bookingRepository = bookingRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    @Transactional
    public BookingDTO bookMeetingRoom(Integer residentId, Integer meetingRoomId, LocalDateTime startTime, LocalDateTime endTime) {
        List<BookingEntity> existingBookings = bookingRepository.findBookingsByMeetingRoomIdAndTimeRange(meetingRoomId, startTime, endTime);
        if (!existingBookings.isEmpty()) {
            throw new EntityNotFoundException("Meeting room is not available");
        }
        MeetingRoomEntity meetingRoomEntity = meetingRoomRepository.findById(meetingRoomId).orElseThrow(() -> new EntityNotFoundException("Meeting room not found"));
        if (meetingRoomEntity == null) throw new EntityNotFoundException("Meeting room not found");
        ResidentEntity resident = residentRepository.findById(residentId).orElseThrow(() -> new EntityNotFoundException("Resident not found"));
        BookingEntity newBooking = new BookingEntity(startTime, endTime, resident, null, meetingRoomEntity);
        bookingRepository.save(newBooking);
        return new BookingDTO(
                newBooking.getStartTime(),
                newBooking.getEndTime(),
                new ResidentDTO(resident.getId(), resident.getName(), resident.getEmail(), new SubscriptionPlanDTO(resident.getSubscriptionPlan().getId(), resident.getSubscriptionPlan().getName(), resident.getSubscriptionPlan().getPrice())),
                null,
                new MeetingRoomDTO(meetingRoomEntity.getId(), meetingRoomEntity.getName(), 4, true)
        );
    }
}
