package com.BusFlow.backend.controller;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.service.BusDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusController {
    @Autowired
    BusDetailsService service;

    @GetMapping("/buses")
    public ResponseEntity<List<BusDetails>> getBuses(){
        return new ResponseEntity<>(service.getBus(), HttpStatus.OK);
    }
}
