package com.safetynet.alerts.repository.Interface;

import com.safetynet.alerts.model.MedicalRecord;

import java.util.List;

public interface IMedicalRecordRepository {

    List<MedicalRecord> medicalRecordlist();

    void addAll(List<MedicalRecord> medicalRecords);

    void add(MedicalRecord medicalRecord);

    void update(MedicalRecord medicalRecord);

    void delete(MedicalRecord medicalRecord);
}