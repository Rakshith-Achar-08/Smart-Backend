package com.BusFlow.backend.service;


import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.repository.BusDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusDetailsService {

    @Autowired
    BusDetailsRepository bus;

    public List<BusDetails> getBus() {
        return bus.findAll();
    }
}
