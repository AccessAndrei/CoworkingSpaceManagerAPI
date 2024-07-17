package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlanEntity extends BaseEntity {
    private String name;
    private Double price;
    private List<ResidentEntity> residents;
    public SubscriptionPlanEntity() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "subscriptionPlan")
    public List<ResidentEntity> getResidents() {
        return residents;
    }

    public void setResidents(List<ResidentEntity> residents) {
        this.residents = residents;
    }
}