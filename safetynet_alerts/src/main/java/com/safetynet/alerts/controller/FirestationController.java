package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }

    @PostMapping("/add")
    public List<Firestation> addFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.add(firestation);
        logger.info("firestation : add( "+ firestation +" )");
        return response;
    }

    @PutMapping("/update")
    public List<Firestation> updateFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.update(firestation);
        logger.info("firestation : update( "+ firestation +" )");
        return response;
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFireStation(@RequestParam String address) {
        List<Firestation> response = firestationService.delete(address);
        logger.info("firestation : delete( "+ address +" )");
        return response;
    }

    @GetMapping("")
    public List getPersonsCoverageStation(@RequestParam String stationNumber) {
        List<StationCoverage> response = firestationService.getPersonsCoverageByStationNumber(stationNumber);
        logger.info("getPersonsCoverageByStationNumber( "+ stationNumber +" )");
        return response;
    }
}