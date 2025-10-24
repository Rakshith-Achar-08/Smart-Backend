package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.BusDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetails,String> {
//    List<BusDetails> findByStartPointContainingAndEndPointContainingIgnoreCase(String start, String end);
}
