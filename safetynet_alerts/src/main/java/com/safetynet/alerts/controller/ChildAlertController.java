package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.service.ChildAlertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildAlertController {

    @Autowired
    ChildAlertService childAlertService;

    @GetMapping("/childAlert")
    public List getChildByAddress(@RequestParam String address) {
        List<ChildAlert> response = childAlertService.getChildByAddress(address);
        return response;
    }
}
