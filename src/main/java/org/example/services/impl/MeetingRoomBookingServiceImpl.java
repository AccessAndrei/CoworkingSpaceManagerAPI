package org.example.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.dto.BookingDTO;
import org.example.dto.MeetingRoomDTO;
import org.example.dto.ResidentDTO;
import org.example.dto.SubscriptionPlanDTO;
import org.example.entities.BookingEntity;
import org.example.entities.EquipmentEntity;
import org.example.entities.MeetingRoomEntity;
import org.example.entities.ResidentEntity;
import org.example.repositories.BookingRepository;
import org.example.repositories.EquipmentRepository;
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
    public MeetingRoomBookingServiceImpl(MeetingRoomRepository meetingRoomRepository,
                                         BookingRepository bookingRepository,
                                         ResidentRepository residentRepository) {
        this.meetingRoomRepository = meetingRoomRepository;
        this.bookingRepository = bookingRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    @Transactional
    public BookingDTO bookMeetingRoom(Integer residentId, LocalDateTime startTime, LocalDateTime endTime, String equipmentName) {
        ResidentEntity resident = residentRepository.findById(residentId)
                .orElseThrow(() -> new EntityNotFoundException("Resident not found"));
        List<MeetingRoomEntity> meetingRooms = (List<MeetingRoomEntity>) meetingRoomRepository.findAll();
        MeetingRoomEntity availableRoom = null;

        for (MeetingRoomEntity room : meetingRooms) {
            List<EquipmentEntity> equipments = room.getEquipment();
            for (EquipmentEntity equipment : equipments) {
                if (equipment.getName().equalsIgnoreCase(equipmentName)) {
                    List<BookingEntity> existingBookings = bookingRepository.findBookingsByMeetingRoomIdAndTimeRange(room.getId(), startTime, endTime);
                    if (existingBookings.isEmpty()) {
                        availableRoom = room;
                        break;
                    }
                }
            }
            if (availableRoom != null) break;
        }

        if (availableRoom == null) {
            throw new EntityNotFoundException("Подходящая комната для переговоров недоступна");
        }
        BookingEntity newBooking = new BookingEntity();
        newBooking.setStartTime(startTime);
        newBooking.setEndTime(endTime);
        newBooking.setResident(resident);
        newBooking.setMeetingRoom(availableRoom);
        bookingRepository.save(newBooking);
        return new BookingDTO(newBooking.getStartTime(), newBooking.getEndTime(), new ResidentDTO(resident.getId(), resident.getName(), resident.getEmail(), new SubscriptionPlanDTO(resident.getSubscriptionPlan().getId(), resident.getSubscriptionPlan().getName(), resident.getSubscriptionPlan().getPrice())), null,
                new MeetingRoomDTO(availableRoom.getId(), availableRoom.getName(), true));
    }
}