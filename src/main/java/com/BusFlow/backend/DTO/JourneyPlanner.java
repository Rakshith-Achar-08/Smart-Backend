package com.BusFlow.backend.DTO;
import com.BusFlow.backend.model.Route;
import com.BusFlow.backend.model.Shape;
import com.BusFlow.backend.model.Stop;

import java.util.List;

public class JourneyPlanner {

    private Route route; // Route details (e.g., "500D")
    private List<Stop> intermediateStops; // All stops from start to end
    private List<Shape> routeShape; // GPS points to draw the path

    public JourneyPlanner(Route route, List<Stop> intermediateStops, List<Shape> routeShape) {
        this.route = route;
        this.intermediateStops = intermediateStops;
        this.routeShape = routeShape;
    }
}
