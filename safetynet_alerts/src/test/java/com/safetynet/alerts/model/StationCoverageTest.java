package com.safetynet.alerts.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StationCoverageTest {

    @Test
    public void stationCoverageTest() {
        List<PersonCovered> personCovered = new ArrayList<>();
        StationCoverage sc = new StationCoverage(1, 1, personCovered);
        String toString = "Coverage: adults = 1, child = 1, person covered = []";

        StationCoverage s = new StationCoverage();
        s.setAdults(1);
        s.setChild(1);
        s.setPersonsCovered(personCovered);

        Assert.assertEquals(1, sc.getChild());
        Assert.assertEquals(1, sc.getAdults());
        Assert.assertEquals(personCovered.size(), sc.getPersonsCovered().size());
        Assert.assertEquals(1, s.getChild());
        Assert.assertEquals(1, s.getAdults());
        Assert.assertEquals(toString, sc.toString());
    }
}
