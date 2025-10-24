package com.BusFlow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BusDetails {


//    private int id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//(eg:BMTC101, BMTC102 etc)

    private int capacity;
    private String routeId;
    @Id
    @Column(unique = true, nullable = false)
    private String busNumber;//(eg: 402B, 50D)

    private String licensePlate;
    private String startPoint;
    private String endPoint;
    private String category;
    private String status;
    // "busDetails" is the name of the field in BusLocation.java

//    private List<BusLocation> locations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "BusDetails{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", routeId='" + routeId + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
