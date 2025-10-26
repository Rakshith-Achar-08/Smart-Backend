package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.BusDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetails,String> {

    @Query("SELECT b FROM BusDetails b " +
            "WHERE LOWER(b.startPoint) LIKE LOWER(CONCAT('%', :startPoint, '%')) " +
            "AND LOWER(b.endPoint) LIKE LOWER(CONCAT('%', :endPoint, '%'))")
    List<BusDetails> findByStartAndEnd(@Param("startPoint") String startPoint, @Param("endPoint") String endPoint);

    List<BusDetails> findByBusNumberContainingIgnoreCase(String busNumber);

//        SELECT b FROM BusDetails b
//        WHERE b.startPoint = :startPoint
//        AND b.endPoint = :endPoint
//        AND b.status = 'Running'
//            ")

//    List<BusDetails> findByStartPointContainingAndEndPointContainingIgnoreCase(String start, String end);
}
