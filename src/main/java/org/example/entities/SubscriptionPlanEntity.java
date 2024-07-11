package org.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SubscriptionPlan")
public class SubscriptionPlanEntity {

    private Long id;
    private String planName;
    private double price;
    private String description;
    private int maxBookings;
    private String additionalServices;
    private List<ResidentEntity> residents;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Plan_Name", nullable = false)
    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    @Column(name = "Price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "Description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Max_Bookings", nullable = false)
    public int getMaxBookings() {
        return maxBookings;
    }

    public void setMaxBookings(int maxBookings) {
        this.maxBookings = maxBookings;
    }

    @Column(name = "Additional_Services")
    public String getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(String additionalServices) {
        this.additionalServices = additionalServices;
    }

    @OneToMany(mappedBy = "subscriptionPlan")
    public List<ResidentEntity> getResidents() {
        return residents;
    }

    public void setResidents(List<ResidentEntity> residents) {
        this.residents = residents;
    }
}