package org.example.repositories;

import org.example.entities.SubscriptionPlanEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionPlanRepository extends GeneralRepository<SubscriptionPlanEntity, Integer> {
    @Query("SELECT sp FROM SubscriptionPlanEntity sp WHERE sp.id > :currentPlanId ORDER BY sp.id ASC LIMIT 1")
    SubscriptionPlanEntity findNextHigherPlan(@Param("currentPlanId") Integer currentPlanId);
}