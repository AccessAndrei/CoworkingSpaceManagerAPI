package org.example.repositories;

import org.example.entities.ResidentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends GeneralRepository<ResidentEntity, Integer> {

}