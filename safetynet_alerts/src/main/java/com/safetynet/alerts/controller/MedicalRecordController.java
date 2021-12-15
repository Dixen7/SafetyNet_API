package com.safetynet.alerts.controller;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.service.MedicalRecordService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicalRecord")
@RestController
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @PostMapping("/add")
    public List<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.add(medicalRecord);
        return response;
    }

    @PutMapping("/update")
    public List<MedicalRecord> updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        List<MedicalRecord> response = medicalRecordService.update(medicalRecord);
        return response;
    }

    @DeleteMapping("/delete")
    public List<MedicalRecord> deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        List<MedicalRecord> response = medicalRecordService.delete(firstName, lastName);
        return response;
    }
}
