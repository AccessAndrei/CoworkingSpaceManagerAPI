package org.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Workplace")
public class WorkplaceEntity {

    private Long id;
    private String workplaceNumber;
    private String type;
    private String location;
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

    @Column(name = "Workplace_Number", nullable = false)
    public String getWorkplaceNumber() {
        return workplaceNumber;
    }

    public void setWorkplaceNumber(String workplaceNumber) {
        this.workplaceNumber = workplaceNumber;
    }

    @Column(name = "Type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "Location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @OneToMany(mappedBy = "workplace")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}