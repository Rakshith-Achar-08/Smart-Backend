package com.BusFlow.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique ID for each point in the shape

    private String shapeId;
    private double shapePtLat;
    private double shapePtLon;
    private int shapePtSequence;
    private double shapeDistTraveled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShapeId() {
        return shapeId;
    }

    public void setShapeId(String shapeId) {
        this.shapeId = shapeId;
    }

    public double getShapePtLon() {
        return shapePtLon;
    }

    public void setShapePtLon(double shapePtLon) {
        this.shapePtLon = shapePtLon;
    }

    public double getShapePtLat() {
        return shapePtLat;
    }

    public void setShapePtLat(double shapePtLat) {
        this.shapePtLat = shapePtLat;
    }

    public int getShapePtSequence() {
        return shapePtSequence;
    }

    public void setShapePtSequence(int shapePtSequence) {
        this.shapePtSequence = shapePtSequence;
    }

    public double getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(double shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", shapeId='" + shapeId + '\'' +
                ", shapePtLat=" + shapePtLat +
                ", shapePtLon=" + shapePtLon +
                ", shapePtSequence=" + shapePtSequence +
                ", shapeDistTraveled=" + shapeDistTraveled +
                '}';
    }
}