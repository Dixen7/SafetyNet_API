package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

    private static final Logger logger = LogManager.getLogger("ChildAlertController");
    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("/add")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.add(medicalRecord);
        logger.info("medicalRecord : add( "+ medicalRecord +" )");
        return response;
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.update(medicalRecord);
        logger.info("medicalRecord : update( "+ medicalRecord +" )");
        return response;
    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> response = medicalRecordService.delete(firstName, lastName);
        logger.info("medicalRecord : delete( "+ firstName + ", "+ lastName +" )");
        return response;
    }
}
