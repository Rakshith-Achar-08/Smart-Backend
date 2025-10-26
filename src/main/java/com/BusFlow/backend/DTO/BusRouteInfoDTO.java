package com.BusFlow.backend.DTO;

import com.BusFlow.backend.model.BusDetails;
import com.BusFlow.backend.model.Shape;
import lombok.Data;

import java.util.List;
@Data
public class BusRouteInfoDTO {
    private BusDetails busInfo;
    private List<Shape> routeShape;

    public BusRouteInfoDTO(BusDetails busInfo, List<Shape> routeShape) {
        this.busInfo = busInfo;
        this.routeShape = routeShape;
    }

}
