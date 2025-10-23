package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.StopTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopTimeRepository  extends JpaRepository<StopTime, Long> {

}
