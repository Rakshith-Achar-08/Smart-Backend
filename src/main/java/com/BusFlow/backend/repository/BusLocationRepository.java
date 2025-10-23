package com.BusFlow.backend.repository;


import com.BusFlow.backend.model.BusLocation;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface BusLocationRepository extends JpaAttributeConverter<BusLocation, Integer> {
}
