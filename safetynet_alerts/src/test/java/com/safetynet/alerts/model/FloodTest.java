package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FloodTest {

    // Test the getters/setters and constructor of Flood class
    @Test
    public void floodTest() {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        Flood flood = new Flood("John", "Doe", 15, "000", medication, allergies);
        String toString = "[ firstname= John, lastName = Doe, age = 15, phone number = 000, medications = [], allergies = []]";

        Assert.assertEquals("John", flood.getFirstName());
        Assert.assertEquals("Doe", flood.getLastName());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(flood.getAge()));
        Assert.assertEquals("000", flood.getPhone());
        Assert.assertEquals(medication, flood.getMedications());
        Assert.assertEquals(allergies, flood.getAllergies());
        Assert.assertEquals(toString, flood.toString());
    }
}
