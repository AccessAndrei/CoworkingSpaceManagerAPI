package org.example.repositories;

import org.example.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends GeneralRepository<EquipmentEntity, Integer> {

    @Query("SELECT e FROM EquipmentEntity e WHERE e.name = :name")
    EquipmentEntity findByName(@Param("name") String name);

    @Query("SELECT e FROM EquipmentEntity e WHERE e.meetingRoom.id = :meetingRoomId")
    List<EquipmentEntity> findByMeetingRoomId(@Param("meetingRoomId") Integer meetingRoomId);
}