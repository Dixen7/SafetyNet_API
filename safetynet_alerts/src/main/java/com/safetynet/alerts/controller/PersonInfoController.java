package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.service.PersonInfoService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonInfoController {

    @Autowired
    PersonInfoService personInfoService;

    @GetMapping("/personInfo")
    public List getAPersonInformation(@RequestParam String firstName, String lastName) {
        List<PersonInfo> response = personInfoService.getPersonInformation(firstName, lastName);
        return response;
    }
}