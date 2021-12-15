package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Household;
import com.safetynet.alerts.service.FloodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class FloodController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final FloodService floodService;

    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping("/flood/stations")
    public List getHouseholdByFireStationAddress(@RequestParam String stations) {
        List<Household> response = floodService.getHouseholdByStationAddress(stations);
        logger.info("getHouseholdByStationAddress( "+ stations +" )");
        return response;
    }
}
