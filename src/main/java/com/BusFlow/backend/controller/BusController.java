package com.BusFlow.backend.controller;

import com.BusFlow.backend.DTO.BusRouteInfoDTO;
import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.DTO.JourneyPlanner;
import com.BusFlow.backend.model.Route;
import com.BusFlow.backend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    public BusService service;
    @CrossOrigin
    @GetMapping("/about-bus")
    public ResponseEntity<List<BusDetails>> get(){
        return new ResponseEntity<>(service.getAllBuses(), HttpStatus.OK);
    }

//    @GetMapping("/buses/{busesNumber}")
//    public  ResponseEntity<BusDetails> getBuses(@PathVariable String busesNumber){
//        return new ResponseEntity<>(service.getBus(busesNumber), HttpStatus.OK);
//    }

    @GetMapping("/routes/search")
    public List<JourneyPlanner> findFullJourney(@RequestParam String from, @RequestParam String to) {
        return service.findJourneys(from, to);
    }



    @GetMapping("/search-route")
    public ResponseEntity<List<Route>> getAllBuses(){
        return new ResponseEntity<>(service.getAllRoutes(), HttpStatus.OK);
    }

    @GetMapping("/track-bus")
    public ResponseEntity<List<BusDetails>> searchBusesByRouteIdPrefix(@RequestParam String prefix) {
        List<BusDetails> buses = service.findBusesByRouteIdPrefix(prefix);
        if (buses.isEmpty()) {
            // If no buses found, return 404 Not Found
            return ResponseEntity.notFound().build();
        } else {
            // If buses are found, return 200 OK with the list
            return ResponseEntity.ok(buses);
        }
    }


//    @GetMapping("/routes/{routeId}")
//    public ResponseEntity<Route> getRoute(@PathVariable String routeId) {
//        Route route = service.getRoute(routeId);
//        if (route != null) {
//            return ResponseEntity.ok(route);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @GetMapping("/track-bus")
//    public ResponseEntity<List<BusRouteInfoDTO>> trackBusByNumber(@RequestParam String busNumber) {
//
//        List<BusRouteInfoDTO> routeInfoList = service.findBusRouteInfoByBusNumber(busNumber);
//
//        if (routeInfoList.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(routeInfoList);
//        }
//    }
}












