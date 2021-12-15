package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FirestationTest {

    // Test the getters/setters and constructor of Firestation class
    @Test
    public void fireStationTest() {
        Firestation fs = new Firestation("000", "111");
        String toString = "Firestation: address = 000, station number = 111";

        Assert.assertEquals("000", fs.getAddress());
        Assert.assertEquals("111", fs.getStation());
        Assert.assertEquals(toString, fs.toString());
    }
}
