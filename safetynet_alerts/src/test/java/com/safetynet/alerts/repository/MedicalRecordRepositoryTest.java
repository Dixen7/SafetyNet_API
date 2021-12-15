package com.safetynet.alerts.repository;


import com.safetynet.alerts.model.MedicalRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class MedicalRecordRepositoryTest {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Test
    void updateMedicalRecord() {
        MedicalRecord result = new MedicalRecord();
        List<String> medications = new ArrayList<>();
        medications.add("aznol:350mg");
        medications.add("hydrapermazol:100mg");
        List<String> allergies = new ArrayList<>();
        allergies.add("nillacilan");
        MedicalRecord medicalRecord = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);

        result.update(medicalRecord);
        medicalRecordRepository.update(medicalRecord);

        assertEquals(medicalRecord.getAllergies(), result.getAllergies());
        assertEquals(medicalRecord.getMedications(), result.getMedications());
    }

    @Test
    void test_addMedicalRecord() {
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        medications.add("aznol:350mg");
        allergies.add("nillacilan");
        MedicalRecord mr = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);

        medicalRecordRepository.add(mr);
        assertEquals(medicalRecordRepository.medicalRecordlist().contains(mr), true);
    }

    @Test
    void test_removeMedicalRecord() {
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        medications.add("aznol:350mg");
        allergies.add("nillacilan");
        MedicalRecord mr = new MedicalRecord("John", "Boyd", "03/06/1984", medications, allergies);

        medicalRecordRepository.delete(mr);
        assertEquals(medicalRecordRepository.medicalRecordlist().contains(mr), false);
    }
}
