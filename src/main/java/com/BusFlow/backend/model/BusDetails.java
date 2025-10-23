package com.BusFlow.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @Id
    @Column(unique = true, nullable = false)

    private String busId;//(eg:BMTC101, BMTC102 etc)

    private String routeName; //(eg: Doddaballapura, yelahanka)
    private int capacity;
    private String busNumber;//(eg: 402B, 50D)
    private String licensePlate;
    private String startPoint;
    private String endPoint;
    private String status;

    @OneToMany(mappedBy = "busDetails")// "busDetails" is the name of the field in BusLocation.java

//    private List<BusLocation> locations;

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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

    @Override
    public String toString() {
        return "BusDetails{" +
                "busId='" + busId + '\'' +
                ", routeName='" + routeName + '\'' +
                ", capacity=" + capacity +
                ", busNumber='" + busNumber + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
