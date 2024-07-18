package org.example.repositories;

import org.example.entities.BookingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends GeneralRepository<BookingEntity, Integer> {

    @Query("SELECT b FROM BookingEntity b WHERE b.meetingRoom.id = :meetingRoomId AND b.startTime < :end AND b.endTime > :start")
    List<BookingEntity> findBookingsByMeetingRoomIdAndTimeRange(@Param("meetingRoomId") Integer meetingRoomId, @Param("start") LocalDateTime startTime, @Param("end") LocalDateTime endTime);

    @Query("SELECT b FROM BookingEntity b WHERE b.workplace.id = :workplaceId AND b.startTime < :end AND b.endTime > :start")
    List<BookingEntity> findBookingsByWorkplaceIdAndTimeRange(@Param("workplaceId") Integer workplaceId, @Param("start") LocalDateTime startTime, @Param("end") LocalDateTime endTime);

    @Query("SELECT b FROM BookingEntity b WHERE b.startTime < :end AND b.endTime > :start")
    List<BookingEntity> findAllByBookingDateBetween(@Param("start") LocalDateTime startTime, @Param("end") LocalDateTime endTime);

}