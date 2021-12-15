package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordTest {

    // Test the getters/setters and constructor of MedicalRecord class
    @Test
    public void medicalRecordTest() {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        MedicalRecord mr = new MedicalRecord("John", "Doe", "01/01/01", medication, allergies);
        String toString = "Person: firstname= John, lastName = Doe, birthdate = 01/01/01, medications = [], allergies = []";

        Assert.assertEquals("John", mr.getFirstName());
        Assert.assertEquals("Doe", mr.getLastName());
        Assert.assertEquals("01/01/01", mr.getBirthdate());
        Assert.assertEquals(medication, mr.getMedications());
        Assert.assertEquals(allergies, mr.getAllergies());
        Assert.assertEquals(toString, mr.toString());

    }
}
