package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PersonTest {

    // Test the getters/setters and constructor of Person class
    @Test
    public void personTest() {
        Person person = new Person("John", "Doe", "Neverland", "Funeralopolis", "000", "45", "john.doe@testmail.com");
        String toString = "Person: firstname= John, lastName = Doe, address = Neverland, city = Funeralopolis, zip = 000, phone number = 45, email = john.doe@testmail.com";

        Assert.assertEquals("John", person.getFirstName());
        Assert.assertEquals("Doe", person.getLastName());
        Assert.assertEquals("Neverland", person.getAddress());
        Assert.assertEquals("Funeralopolis", person.getCity());
        Assert.assertEquals("000", person.getZip());
        Assert.assertEquals("45", person.getPhone());
        Assert.assertEquals("john.doe@testmail.com", person.getEmail());
        Assert.assertEquals(toString, person.toString());
    }
}
