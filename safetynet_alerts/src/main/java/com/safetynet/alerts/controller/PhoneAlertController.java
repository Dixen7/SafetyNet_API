package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.PhoneAlertService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhoneAlertController {

    @Autowired
    PhoneAlertService phoneAlertService;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersByCoverageStation(@RequestParam String firestation) {
        List<String> response = phoneAlertService.getPhoneNumberByCoverage(firestation);
        return response;
    }

}
