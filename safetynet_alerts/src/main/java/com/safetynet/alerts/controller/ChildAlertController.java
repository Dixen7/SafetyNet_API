package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildAlertController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final ChildAlertService childAlertService;

    public ChildAlertController(ChildAlertService childAlertService) {
        this.childAlertService = childAlertService;
    }

    @GetMapping("/childAlert")
    public List getChildByAddress(@RequestParam String address) {
        List<ChildAlert> response = childAlertService.getChildByAddress(address);
        logger.info("getChildByAddress( "+ address +" )");
        return response;
    }
}
