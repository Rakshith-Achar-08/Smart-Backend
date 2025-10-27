package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, String> {

    Trip findFirstByRouteId(String routeId);

}
