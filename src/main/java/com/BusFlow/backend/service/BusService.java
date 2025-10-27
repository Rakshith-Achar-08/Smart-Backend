package com.BusFlow.backend.service;

import com.BusFlow.backend.DTO.BusRouteInfoDTO;
import com.BusFlow.backend.model.*;
import com.BusFlow.backend.DTO.JourneyPlanner;
import com.BusFlow.backend.repository.BusDetailsRepository;
import com.BusFlow.backend.repository.RouteRepository;
import com.BusFlow.backend.repository.StopRepository;
import com.BusFlow.backend.repository.StopTimeRepository;
import com.BusFlow.backend.repository.ShapeRepository;
import com.BusFlow.backend.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired private BusDetailsRepository busDetailsRepository;
    @Autowired private StopRepository stopRepository;
    @Autowired private StopTimeRepository stopTimeRepository;
    @Autowired private TripRepository tripRepository;
    @Autowired private RouteRepository routeRepository;
    @Autowired private ShapeRepository shapeRepository;

    public BusDetails busDetails;

    public List<BusDetails> getAllBuses(){
        return busDetailsRepository.findAll();
    }

    public BusDetails getBus(String busesNumber){
        return busDetailsRepository.findById(busesNumber).orElse(null);
    }

    public Route route;
    //to get all the bus information

    public Route getRoute(String routeId){
        return routeRepository.findById(routeId).orElse(null);
    }

    public List<Route> getAllRoutes(){
        return routeRepository.findAll();
    }


    public List<JourneyPlanner> findJourneys(String fromStopName, String toStopName) {
        // 1. Find the start and end stop objects
        Stop fromStop = stopRepository.findByStopNameIgnoreCase(fromStopName);
        Stop toStop = stopRepository.findByStopNameIgnoreCase(toStopName);

        if (fromStop == null || toStop == null) {
            return Collections.emptyList(); // Stops not found
        }

        // 2. Get all schedule entries for the start and end stops
        List<StopTime> startStopTimes = stopTimeRepository.findByStopId(fromStop.getStopId());
        List<StopTime> endStopTimes = stopTimeRepository.findByStopId(toStop.getStopId());

        // 3. Map end trips for fast lookup: Map<tripId, stopSequence>
        Map<String, Integer> endTripsMap = endStopTimes.stream()
                .collect(Collectors.toMap(StopTime::getTripId, StopTime::getStopSequence, (seq1, seq2) -> seq1));

        List<JourneyPlanner> journeyPlans = new ArrayList<>();
        Set<String> processedRouteIds = new HashSet<>(); // To avoid adding the same route multiple times

        // 4. Find common trips where the start stop comes before the end stop
        for (StopTime start : startStopTimes) {
            String tripId = start.getTripId();
            int startSequence = start.getStopSequence();

            if (endTripsMap.containsKey(tripId) && endTripsMap.get(tripId) > startSequence) {
                // This is a valid trip!
                int endSequence = endTripsMap.get(tripId);

                // 5. Get the full Trip object to find the routeId and shapeId
                Optional<Trip> tripOpt = tripRepository.findById(tripId);
                if (tripOpt.isEmpty()) continue;

                Trip trip = tripOpt.get();
                String routeId = trip.getRouteId();
                String shapeId = trip.getShapeId();

                // 6. Check if we've already added this route
                if (processedRouteIds.contains(routeId)) continue;
                processedRouteIds.add(routeId);

                // 7. Get the Route details (e.g., "500D")
                Route route = routeRepository.findById(routeId).orElse(null);

                // 8. Get all intermediate stops
                List<StopTime> intermediateStopTimes = stopTimeRepository
                        .findByTripIdAndStopSequenceBetweenOrderByStopSequenceAsc(tripId, startSequence, endSequence);
                List<String> stopIds = intermediateStopTimes.stream().map(StopTime::getStopId).collect(Collectors.toList());
                List<Stop> intermediateStops = stopRepository.findAllById(stopIds);

                // 9. Get the route shape (the path to draw on the map)
                List<Shape> routeShape = shapeRepository.findByShapeIdOrderByShapePtSequenceAsc(shapeId);

                // 10. Add the complete plan to our list
                journeyPlans.add(new JourneyPlanner(route, intermediateStops, routeShape));
            }
        }
        return journeyPlans;
    }



    public List<BusRouteInfoDTO> findBusRouteInfoByBusNumber(String busNumber) {

        List<BusDetails> buses = busDetailsRepository.findByBusNumberContainingIgnoreCase(busNumber);

        return buses.stream().map(bus -> {
            String shapeId = bus.getShapeId(); // Get shape_id directly from the bus
            List<Shape> routeShape = Collections.emptyList();

            // This 'if' will now work!
            if (shapeId != null) {
                routeShape = shapeRepository.findByShapeIdOrderByShapePtSequenceAsc(shapeId);
            }

            return new BusRouteInfoDTO(bus, routeShape);

        }).collect(Collectors.toList());
    }

}










