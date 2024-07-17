package org.example.controllers;

import org.example.dto.BookingDTO;
import org.example.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/workplace")
    public BookingDTO bookWorkplace(@RequestParam Integer residentId,
                                    @RequestParam Integer workplaceId,
                                    @RequestParam LocalDateTime startTime,
                                    @RequestParam LocalDateTime endTime) {
        return bookingService.bookWorkplace(residentId, workplaceId, startTime, endTime);
    }
}