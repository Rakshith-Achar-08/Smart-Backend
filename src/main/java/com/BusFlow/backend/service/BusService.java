package com.BusFlow.backend.service;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.model.Route;
import com.BusFlow.backend.repository.BusDetailsRepository;
import com.BusFlow.backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    @Autowired
    public BusDetailsRepository bus;
    @Autowired
    private RouteRepository routeRepository;
    public Route route;
    //to get all the bus information

    public Route getBus(String routeId){
        return routeRepository.findById(routeId).orElse(null);
    }

    public List<Route> getAllBuses(){
        return routeRepository.findAll();
    }

}










