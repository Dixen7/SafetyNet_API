package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseholdTest {

    // Test the getters/setters and constructor of HouseHold class
    @Test
    public void householdTest() {
        List<Flood> flood = new ArrayList<>();
        Household hh = new Household("000", flood);
        String toString = "address= 000, person = []";

        Household h = new Household();
        h.setAddress("000");
        h.setFlood(flood);

        Assert.assertEquals("000", hh.getAddress());
        Assert.assertEquals(flood.size(), hh.getFlood().size());
        Assert.assertEquals("000", h.getAddress());
        Assert.assertEquals(toString, hh.toString());
    }
}
