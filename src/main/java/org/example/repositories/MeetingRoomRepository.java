package org.example.repositories;

import org.example.entities.MeetingRoomEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MeetingRoomRepository extends GeneralRepository<MeetingRoomEntity, Integer> {
}