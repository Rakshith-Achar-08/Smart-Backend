package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.StopTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopTimeRepository  extends JpaRepository<StopTime, Long> {
    // Finds all schedule entries for a specific stop
    List<StopTime> findByStopId(String stopId);

    // Finds all stops on a trip that fall between two sequence numbers
    List<StopTime> findByTripIdAndStopSequenceBetweenOrderByStopSequenceAsc(String tripId, int startSequence, int endSequence);
}
