package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.CrowdData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrowdDataRepository extends JpaRepository<CrowdData, Integer> {
}
