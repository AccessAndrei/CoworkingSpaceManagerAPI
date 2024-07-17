package org.example.services;

import org.example.dto.BookingDTO;
import org.example.dto.MeetingRoomDTO;
import java.time.LocalDateTime;

public interface MeetingRoomBookingService {
    BookingDTO bookMeetingRoom(Integer residentId, Integer meetingRoomId, LocalDateTime startTime, LocalDateTime endTime);
}
