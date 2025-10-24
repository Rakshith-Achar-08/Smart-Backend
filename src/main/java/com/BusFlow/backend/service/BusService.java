package com.BusFlow.backend.service;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.model.Route;
import com.BusFlow.backend.repository.BusDetailsRepository;
import com.BusFlow.backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public BusDetails busDetails;

    public List<BusDetails> getAllBuses(){
        return bus.findAll();
    }

    public BusDetails getBus(String busesNumber){
        return bus.findById(busesNumber).orElse(null);
    }

    public Route route;
    //to get all the bus information

    public Route getRoute(String routeId){
        return routeRepository.findById(routeId).orElse(null);
    }

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }

}










