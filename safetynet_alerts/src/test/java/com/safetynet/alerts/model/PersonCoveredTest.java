package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PersonCoveredTest {

    // Test the getters/setters and constructor of PersonCovered class
    @Test
    public void personCoveredTest() {
        PersonCovered pc = new PersonCovered("John", "Doe", "000", "000");
        String toString = "[firstName = John, lastName = Doe, address = 000, phone number = 000]";

        Assert.assertEquals("John", pc.getFirstName());
        Assert.assertEquals("Doe", pc.getLastName());
        Assert.assertEquals("000", pc.getAddress());
        Assert.assertEquals("000", pc.getPhone());
        Assert.assertEquals(toString, pc.toString());
    }
}
