package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonInfoTest {

    // Test the getters/setters and constructor of PersonInfo class
    @Test
    public void personInfoTest() {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        PersonInfo pi = new PersonInfo("John", "Doe", "000", 15, "000", medication, allergies);
        String toString = "Person: firstname= John, lastName = Doe, address = 000, age = 15, email = 000, medications = [], allergies = []";

        Assert.assertEquals("John", pi.getFirstName());
        Assert.assertEquals("Doe", pi.getLastName());
        Assert.assertEquals("000", pi.getAddress());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(pi.getAge()));
        Assert.assertEquals("000", pi.getEmail());
        Assert.assertEquals(medication, pi.getMedications());
        Assert.assertEquals(allergies, pi.getAllergies());
        Assert.assertEquals(toString, pi.toString());
    }
}
