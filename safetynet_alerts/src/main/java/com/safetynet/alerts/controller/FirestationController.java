package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;
import com.safetynet.alerts.service.FirestationService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

    @Autowired
    FirestationService firestationService;

    @PostMapping("/add")
    public List<Firestation> addFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.add(firestation);
        return response;
    }

    @PutMapping("/update")
    public List<Firestation> updateFireStation(@RequestBody Firestation firestation) {
        List<Firestation> response = firestationService.update(firestation);
        return response;
    }

    @DeleteMapping("/delete")
    public List<Firestation> deleteFireStation(@RequestParam String address) {
        List<Firestation> response = firestationService.delete(address);
        return response;
    }

    @GetMapping("")
    public List getPersonsCoverageStation(@RequestParam String stationNumber) {
        List<StationCoverage> response = firestationService.getPersonsCoverageByStationNumber(stationNumber);
        return response;
    }
}