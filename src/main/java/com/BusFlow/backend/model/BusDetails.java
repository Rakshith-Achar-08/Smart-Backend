package com.BusFlow.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "bus_details")

//@RequestMapping("/api")
public class BusDetails {

//    private int id;

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;//(eg:BMTC101, BMTC102 etc)
    @Column(name = "capacity")
    private int capacity;

    @Id
    @Column(name = "route_id", unique = true, nullable = false)
    private String routeId;
    @Column(name = "bus_number")
    private String busNumber;//(eg: 402B, 50D)

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "start_point")
    private String startPoint;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "category")
    private String category;

    @Column(name="status")
    private String status;

    @Column(name="shape_id")
    private String shapeId;

    // "busDetails" is the name of the field in BusLocation.java

//    private List<BusLocation> locations;


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    public void setShapeId(String shapeId){
        this.shapeId=shapeId;
    }

    public String getShapeId(){
        return shapeId;
    }

    @Override
    public String toString() {
        return "BusDetails{" +
                "capacity=" + capacity +
                ", routeId='" + routeId + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                ", shapeId='" + shapeId + '\'' +
                '}';
    }
}
