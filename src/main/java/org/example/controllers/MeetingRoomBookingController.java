package org.example.controllers;

import org.example.dto.BookingDTO;
import org.example.services.MeetingRoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/bookings")
public class MeetingRoomBookingController {
    private final MeetingRoomBookingService meetingRoomBookingService;
    @Autowired
    public MeetingRoomBookingController(MeetingRoomBookingService meetingRoomBookingService) {
        this.meetingRoomBookingService = meetingRoomBookingService;
    }
    @PostMapping("/meeting-room")
    public BookingDTO bookMeetingRoom(@RequestParam Integer residentId,
                                      @RequestParam LocalDateTime startTime,
                                      @RequestParam LocalDateTime endTime,
                                      @RequestParam String equipmentName) {
        return meetingRoomBookingService.bookMeetingRoom(residentId, startTime, endTime, equipmentName);
    }
}