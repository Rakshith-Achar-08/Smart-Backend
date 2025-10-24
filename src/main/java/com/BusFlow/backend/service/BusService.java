package com.BusFlow.backend.service;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.repository.BusDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusService {
    @Autowired
    private BusDetailsRepository busDetailsRepository;

    public List<BusDetails> findBusesBetweenPoints(String startPoint, String endPoint) {
        return busDetailsRepository.findByStartPointContainingAndEndPointContainingIgnoreCase(startPoint, endPoint);
    }
}
