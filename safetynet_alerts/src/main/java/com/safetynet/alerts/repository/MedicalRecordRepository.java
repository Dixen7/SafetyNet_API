package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.repository.Interface.IMedicalRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRecordRepository implements IMedicalRecordRepository {

    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    @Override
    public void addAll(List<MedicalRecord> medicalRecords) {
        this.medicalRecords.addAll(medicalRecords);
    }

    @Override
    public List<MedicalRecord> medicalRecordlist() {
        return medicalRecords;
    }

    @Override
    public void add(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    @Override
    public void update(MedicalRecord medicalRecord) {
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getFirstName().equalsIgnoreCase(medicalRecord.getFirstName()) && mr.getLastName().equalsIgnoreCase(medicalRecord.getLastName())) {
                mr.update(medicalRecord);
                break;
            }
        }
    }

    @Override
    public void delete(MedicalRecord medicalRecord) {
        for (MedicalRecord mr : medicalRecords) {
            if (mr.getFirstName().equalsIgnoreCase(medicalRecord.getFirstName()) && mr.getLastName().equalsIgnoreCase(medicalRecord.getLastName())) {
                medicalRecords.remove(mr);
                break;
            }
        }
    }

}