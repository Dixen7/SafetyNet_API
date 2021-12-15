package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.service.FireAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireAlertController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final FireAlertService fireAlertService;

    public FireAlertController(FireAlertService fireAlertService) {
        this.fireAlertService = fireAlertService;
    }

    @GetMapping("/fire")
    public List getPersonsByAddress(@RequestParam String address) {
        List<FireAlert> response = fireAlertService.getPersonsByAddress(address);
        logger.info("getPersonsByAddress( "+ address +" )");
        return response;
    }
}
