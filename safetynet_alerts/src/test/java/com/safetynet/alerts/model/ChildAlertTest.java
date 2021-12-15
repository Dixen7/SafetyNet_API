package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertTest {


    // Test the getters/setters and constructor of ChildAlert class
    @Test
    public void childAlertTest() {
        List<String> family = new ArrayList<>();
        family.add("eee");
        ChildAlert childAlert = new ChildAlert("John", "Doe", 2, family);
        String toString = "Children: firstName= John, lastName = Doe, age= 2, family = [eee]";

        Assert.assertEquals("John", childAlert.getFirstName());
        Assert.assertEquals("Doe", childAlert.getLastName());
        Assert.assertEquals(java.util.Optional.of(2), java.util.Optional.of(childAlert.getAge()));
        Assert.assertEquals(toString, childAlert.toString());
    }
}
