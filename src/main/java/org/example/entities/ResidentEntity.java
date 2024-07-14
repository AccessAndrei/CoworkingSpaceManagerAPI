package org.example.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "residents")
public class ResidentEntity extends BaseEntity {
    private String name;
    private String email;
    private List<BookingEntity> bookings;
    private SubscriptionPlanEntity subscriptionPlan;

    public ResidentEntity() {}

    public ResidentEntity(String name, String email, SubscriptionPlanEntity subscriptionPlan) {
        this.name = name;
        this.email = email;
        this.subscriptionPlan = subscriptionPlan;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY,mappedBy = "resident")
    public List<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_plan_id")
    public SubscriptionPlanEntity getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlanEntity subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}