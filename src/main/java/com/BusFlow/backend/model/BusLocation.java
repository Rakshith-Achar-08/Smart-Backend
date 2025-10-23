package com.BusFlow.backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusLocation {

    @Id
    private int Busid;

    @ManyToOne
    @JoinColumn(name = "bus_Id", referencedColumnName = "busId")
    private BusDetails bus;

    private double latitude;
    private double longitude;
    private String nextBusStop;
    private LocalDateTime timestamp;

    public int getBusid() {
        return Busid;
    }

    public void setBusid(int busid) {
        Busid = busid;
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

    public BusDetails getBus() {
        return bus;
    }

    public void setBus(BusDetails bus) {
        this.bus = bus;
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
                "Busid=" + Busid +
                ", bus=" + bus +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nextBusStop='" + nextBusStop + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
