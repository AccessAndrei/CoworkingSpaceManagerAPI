package org.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "workplaces")
public class WorkplaceEntity extends BaseEntity {
    private String name;
    private List<BookingEntity> bookings;

    public WorkplaceEntity(String name, List<BookingEntity> bookings) {
        this.name = name;
        this.bookings = bookings;
    }

    public WorkplaceEntity() {

    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,mappedBy = "workplace")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }
}