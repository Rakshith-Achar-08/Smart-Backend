package com.BusFlow.backend;

import com.BusFlow.backend.model.Route; // Change this to your specific class
import com.BusFlow.backend.model.Shape;
import com.BusFlow.backend.model.Stop;
import com.BusFlow.backend.model.StopTime;
import com.BusFlow.backend.repository.RouteRepository; // Change this to your specific repository
import com.BusFlow.backend.repository.ShapeRepository;
import com.BusFlow.backend.repository.StopRepository;
import com.BusFlow.backend.repository.StopTimeRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;


@Component
public class DataLoader implements CommandLineRunner{
    @Autowired private RouteRepository routeRepository;
    @Autowired private StopRepository stopRepository;
    @Autowired private ShapeRepository shapeRepository;
    @Autowired private StopTimeRepository stopTimeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoutes();
        loadStops();
        loadShapes();
        loadStopTimes();
    }



    private void loadRoutes() {
        if (routeRepository.count() == 0) {
            try {
                InputStream inputStream = new ClassPathResource("Data/routes.txt").getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    reader.lines().skip(1).forEach(line -> {
                        String[] values = line.split(",");
                        Route route = new Route();
                        route.setRouteId(values[4]);
                        route.setRouteShortName(values[1]);
                        route.setRouteLongName(values[0]);
                        routeRepository.save(route);
                    });
                    System.out.println("Routes data loaded!");
                }
            } catch (Exception e) { System.out.println("Error loading routes: " + e.getMessage()); }
        }
    }

    private void loadStops() {
        if (stopRepository.count() == 0) {
            try {
                InputStream inputStream = new ClassPathResource("Data/stops.txt").getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    reader.lines().skip(1).forEach(line -> {
                        String[] values = line.split(",");
                        Stop stop = new Stop();
                        stop.setStopId(values[2]);
                        stop.setStopName(values[0]);
                        stop.setStopLat(Double.parseDouble(values[3]));
                        stop.setStopLon(Double.parseDouble(values[4]));
                        stopRepository.save(stop);
                    });
                    System.out.println("Stops data loaded!");
                }
            } catch (Exception e) { System.out.println("Error loading stops: " + e.getMessage()); }
        }
    }
//

    private void loadShapes() {
        if (shapeRepository.count() == 0) {
            final int BATCH_SIZE = 3000; // Process 3000 records at a time
            List<Shape> shapesToSave = new ArrayList<>();

            try {
                InputStream inputStream = new ClassPathResource("Data/shapes.txt").getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                    String line;
                    reader.readLine(); // Skip header row
                    while ((line = reader.readLine()) != null) {
                        String[] values = line.split(",");
                        Shape shape = new Shape();
                        shape.setShapeId(values[0]);
                        shape.setShapePtLat(Double.parseDouble(values[1]));
                        shape.setShapePtLon(Double.parseDouble(values[2]));
                        shape.setShapePtSequence(Integer.parseInt(values[3]));
                        shapesToSave.add(shape);

                        // When the list reaches the batch size, save it and clear it
                        if (shapesToSave.size() == BATCH_SIZE) {
                            shapeRepository.saveAll(shapesToSave);
                            shapesToSave.clear(); // Clear the list for the next batch
                        }
                    }

                    // Save any remaining records
                    if (!shapesToSave.isEmpty()) {
                        shapeRepository.saveAll(shapesToSave);
                    }

                    System.out.println("All shapes data loaded successfully!");
                }
            } catch (Exception e) {
                System.out.println("Error loading shapes: " + e.getMessage());
            }
        }
    }
//    private void loadShapes() {
//        if (shapeRepository.count() == 0) {
//            try {
//                InputStream inputStream = new ClassPathResource("data/shapes.txt").getInputStream();
//                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//                    reader.lines().skip(1).forEach(line -> {
//                        String[] values = line.split(",");
//                        Shape shape = new Shape();
//                        shape.setShapeId(values[0]);
//                        shape.setShapePtLat(Double.parseDouble(values[1]));
//                        shape.setShapePtLon(Double.parseDouble(values[2]));
//                        shape.setShapePtSequence(Integer.parseInt(values[3]));
//                        shapeRepository.save(shape);
//                    });
//                    System.out.println("Shapes data loaded!");
//                }
//            } catch (Exception e) { System.out.println("Error loading shapes: " + e.getMessage()); }
//        }
//    }
//
    private void loadStopTimes() {
        if (stopTimeRepository.count() == 0) {
            final int BATCH_SIZE = 3000;
            List<StopTime> stopTimesToSave = new ArrayList<>();

            try {
                InputStream inputStream = new ClassPathResource("Data/stop_times.txt").getInputStream();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                    String line;
                    reader.readLine(); // Skip header row
                    while ((line = reader.readLine()) != null) {
                        String[] values = line.split(",");

                        StopTime stopTime = new StopTime();
                        stopTime.setTripId(values[0]);
                        stopTime.setArrivalTime(values[1]);
                        stopTime.setDepartureTime(values[2]);
                        stopTime.setStopId(values[3]);
                        stopTime.setStopSequence(Integer.parseInt(values[4]));
                        stopTime.setStopHeadings(values[5]);
                        stopTimesToSave.add(stopTime);

                        // When the list reaches the batch size, save it and clear it
                        if (stopTimesToSave.size() == BATCH_SIZE) {
                            stopTimeRepository.saveAll(stopTimesToSave);
                            stopTimesToSave.clear();
                        }
                    }

                    // Save any remaining records that didn't fill a full batch
                    if (!stopTimesToSave.isEmpty()) {
                        stopTimeRepository.saveAll(stopTimesToSave);
                    }

                    System.out.println("All StopTimes data loaded successfully!");
                }
            } catch (Exception e) {
                System.out.println("Error loading stop times: " + e.getMessage());
            }
        }
    }

//    private void loadStopTimes() {
//        if (stopTimeRepository.count() == 0) {
//            try {
//                InputStream inputStream = new ClassPathResource("data/stop_times.txt").getInputStream();
//                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
//                    reader.lines().skip(1).forEach(line -> {
//                        String[] values = line.split(",");
//                        StopTime stopTime = new StopTime();
//                        stopTime.setTripId(values[0]);
//                        stopTime.setArrivalTime(values[1]);
//                        stopTime.setDepartureTime(values[2]);
//                        stopTime.setStopId(values[3]);
//                        stopTime.setStopSequence(Integer.parseInt(values[4]));
//                        stopTime.setStopHeadings(values[5]);
//                        stopTimeRepository.save(stopTime);
//                    });
//                    System.out.println("StopTimes data loaded!");
//                }
//            } catch (Exception e) { System.out.println("Error loading stop times: " + e.getMessage()); }
//        }
//    }
}
