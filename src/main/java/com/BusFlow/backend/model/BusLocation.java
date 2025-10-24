package com.BusFlow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusLocation {
    // ... other fields


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private double latitude;
    private double longitude;
    private String nextBusStop;
    private LocalDateTime timestamp;

    public String getid() {
        return id;
    }

    public void setBusid(String id) {
        this.id = id;
    }

    public String getNextBusStop() {
        return nextBusStop;
    }

    public void setNextBusStop(String nextBusStop) {
        this.nextBusStop = nextBusStop;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "BusLocation{" +
                "Busid=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nextBusStop='" + nextBusStop + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
