package org.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "meeting_rooms")
public class MeetingRoomEntity extends BaseEntity {
    private String name;
    private List<BookingEntity> bookings;
    private List<EquipmentEntity> equipment;

    public MeetingRoomEntity() {}

    public MeetingRoomEntity(String name) {
        this.name = name;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "meetingRoom")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,mappedBy = "meetingRoom")
    public List<EquipmentEntity> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<EquipmentEntity> equipment) {
        this.equipment = equipment;
    }
}