package com.safetynet.alerts.DataBase;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private final List<Person> persons = new ArrayList<>();
    private final List<Firestation> firestations = new ArrayList<>();
    private final List<MedicalRecord> medicalrecords = new ArrayList<>();

    public DataStore() {
        super();
    }

    public List<Person> getPersons() {
        return persons;
    }
    public List<Firestation> getFirestations() {
        return firestations;
    }
    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }
}
