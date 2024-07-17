package org.example.dto;

import java.util.List;

public class ResidentDTO {
    private Integer id;
    private String name;
    private String email;
    private SubscriptionPlanDTO subscriptionPlan;


    public ResidentDTO(Integer id, String name, String email, SubscriptionPlanDTO subscriptionPlan) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.subscriptionPlan = subscriptionPlan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SubscriptionPlanDTO getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlanDTO subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}