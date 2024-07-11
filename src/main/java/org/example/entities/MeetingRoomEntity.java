package org.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "MeetingRoom")
public class MeetingRoomEntity {

    private Long id;
    private String roomNumber;
    private int capacity;
    private String availableEquipment;
    private String status;
    private List<BookingEntity> bookings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Room_Number", nullable = false)
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "Capacity", nullable = false)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Column(name = "Available_Equipment")
    public String getAvailableEquipment() {
        return availableEquipment;
    }

    public void setAvailableEquipment(String availableEquipment) {
        this.availableEquipment = availableEquipment;
    }

    @Column(name = "Status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "meetingRoom")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}