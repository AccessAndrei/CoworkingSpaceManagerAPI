package org.example.services;

import org.example.dto.BookingDTO;
import java.time.LocalDateTime;

public interface BookingService {
    BookingDTO bookWorkplace(Integer residentId, Integer workplaceId, LocalDateTime startTime, LocalDateTime endTime);
}