package com.BusFlow.backend.repository;

import com.BusFlow.backend.model.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShapeRepository extends JpaRepository<Shape, Long> {
    List<Shape> findByShapeIdOrderByShapePtSequenceAsc(String shapeId);
}
