package com.BusFlow.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Entity
public class CrowdData {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "busId")
    private BusDetails bus;

    private int onBoardCount;

    private int entered;

    private int exited;

    private String stopName;

    private LocalDateTime timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public int getExited() {
        return exited;
    }

    public void setExited(int exited) {
        this.exited = exited;
    }

    public int getEntered() {
        return entered;
    }

    public void setEntered(int entered) {
        this.entered = entered;
    }

    public int getOnBoardCount() {
        return onBoardCount;
    }

    public void setOnBoardCount(int onBoardCount) {
        this.onBoardCount = onBoardCount;
    }

    public BusDetails getBus() {
        return bus;
    }

    public void setBus(BusDetails bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "CrowdData{" +
                "id=" + id +
                ", bus=" + bus +
                ", onBoardCount=" + onBoardCount +
                ", entered=" + entered +
                ", exicted=" + exited +
                ", stopName='" + stopName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
