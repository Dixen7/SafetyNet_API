package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FireAlertTest {

    // Test the getters/setters and constructor of FireAlert class
    @Test
    public void fireAlertTest()  {
        List<String> medication = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        List<String> stationNumber = new ArrayList<>();
        stationNumber.add("z");
        FireAlert fa = new FireAlert("John", "Doe", 15, "000", medication, allergies, stationNumber);
        String toString = "Person: firstname= John, lastName = Doe, age = 15, phone number = 000, medications = [], allergies = [], station number = [z]";

        Assert.assertEquals("John", fa.getFirstName());
        Assert.assertEquals("Doe", fa.getLastName());
        Assert.assertEquals(java.util.Optional.of(15), java.util.Optional.of(fa.getAge()));
        Assert.assertEquals("000", fa.getPhone());
        Assert.assertEquals(medication, fa.getMedications());
        Assert.assertEquals(allergies, fa.getAllergies());
        Assert.assertEquals(toString, fa.toString());
    }
}
