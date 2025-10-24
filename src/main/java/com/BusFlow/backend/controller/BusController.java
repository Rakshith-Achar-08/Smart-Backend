package com.BusFlow.backend.controller;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.model.Route;
import com.BusFlow.backend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BusController {
    @Autowired
    public BusService service;

    @GetMapping("/buses")
    public ResponseEntity<List<BusDetails>> get(){
        return new ResponseEntity<>(service.getAllBuses(), HttpStatus.OK);
    }

    @GetMapping("/buses/{busesNumber}")
    public  ResponseEntity<BusDetails> getBuses(@PathVariable String busesNumber){
        return new ResponseEntity<>(service.getBus(busesNumber), HttpStatus.OK);
    }



    @GetMapping("/routes")
    public ResponseEntity<List<Route>> getAllBuses(){
        return new ResponseEntity<>(service.getAllRoutes(), HttpStatus.OK);
    }

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<Route> getRoute(@PathVariable String routeId) {
        Route route = service.getRoute(routeId);
        if (route != null) {
            return ResponseEntity.ok(route);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}












