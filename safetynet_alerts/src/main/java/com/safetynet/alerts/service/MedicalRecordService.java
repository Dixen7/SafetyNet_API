package com.safetynet.alerts.service;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<MedicalRecord> add(MedicalRecord medicalRecord) {
        List<MedicalRecord> medicalRecordsList = medicalRecordRepository.medicalRecordlist();
        medicalRecordsList.add(medicalRecord);
        return medicalRecordsList;

    }

    public List<MedicalRecord> update(MedicalRecord medicalRecord) {
        String firstName = medicalRecord.getFirstName();
        String lastName = medicalRecord.getLastName();

        List<MedicalRecord> medicalRecordsList = medicalRecordRepository.medicalRecordlist();

        for (MedicalRecord mr : medicalRecordsList) {
            if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                mr.setBirthdate(medicalRecord.getBirthdate());
                mr.setMedications(medicalRecord.getMedications());
                mr.setAllergies(medicalRecord.getAllergies());
            }
        }
        return medicalRecordsList;

    }

    public List<MedicalRecord> delete(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordsList = medicalRecordRepository.medicalRecordlist();

        medicalRecordsList.removeIf(mr -> mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName));
        return medicalRecordsList;
    }

    public int getAge(String firstname, String lastName) {
        int age = 0;
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordlist();
        for (MedicalRecord mr : medicalRecordList) {
            if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastName)) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate birthdate = LocalDate.parse(mr.getBirthdate(), formatter);
                age = Period.between(birthdate, LocalDate.now()).getYears();
            }
        }
        return age;
    }

    public List<String> getMedications(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordlist();
        List<String>  medications = new ArrayList<>();

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                medications = mr.getMedications();
            }
        }
        return medications;
    }

    public List<String> getAllergies(String firstName, String lastName) {
        List<MedicalRecord> medicalRecordList = medicalRecordRepository.medicalRecordlist();
        List<String> allergies = new ArrayList<>();

        for(MedicalRecord mr: medicalRecordList) {
            if(mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                allergies = mr.getAllergies();
            }
        }
        return allergies;
    }
}
