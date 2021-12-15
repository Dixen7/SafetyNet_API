package com.safetynet.alerts.controller;

import com.safetynet.alerts.service.CommunityEmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommunityEmailController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final CommunityEmailService communityEmailService;

    public CommunityEmailController(CommunityEmailService communityEmailService) {
        this.communityEmailService = communityEmailService;
    }

    @GetMapping("/communityEmail")
    public List<String> getEmailsByCity(@RequestParam String city) {
        List<String> response = communityEmailService.getEmailByCity(city);
        logger.info("getEmailByCity( "+ city +" )");
        return response;    }
}
