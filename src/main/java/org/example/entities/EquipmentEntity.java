package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class EquipmentEntity extends BaseEntity {
    private String name;
    private MeetingRoomEntity meetingRoom;
    public EquipmentEntity() {}

    public EquipmentEntity(String name, MeetingRoomEntity meetingRoom) {
        this.name = name;
        this.meetingRoom = meetingRoom;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id")
    public MeetingRoomEntity getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoomEntity meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}