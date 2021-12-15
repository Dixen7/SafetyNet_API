package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.repository.FirestationRepository;
import com.safetynet.alerts.repository.MedicalRecordRepository;
import com.safetynet.alerts.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FloodServiceTest {

    private static FloodService floodService;

    private static MedicalRecordService medicalRecordService;

    private static PersonRepository personRepository;

    private static FirestationRepository firestationRepository;

    private static MedicalRecordRepository medicalRecordRepository;


    @BeforeAll
    private static void setup() {
        personRepository = mock(PersonRepository.class);
        firestationRepository = mock(FirestationRepository.class);
        MedicalRecordRepository medicalRecordRepository = mock(MedicalRecordRepository.class);
        FirestationService firestationService = new FirestationService(personRepository, firestationRepository, medicalRecordService);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepository);
        floodService = new FloodService(personRepository,medicalRecordService, firestationService);
    }
    // test the getHouseholdByStationAddress method from FloodService class
    // it must return a List of Household
    @Test
    public void getFloodTest() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setFirstName("John");
        person1.setLastName("Boyd");
        person1.setAddress("1509 Culver St");
        person1.setPhone("test");
        personList.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Jacob");
        person2.setLastName("Boyd");
        person2.setAddress("1510 Culver St");
        person2.setPhone("test");
        personList.add(person2);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);

        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        Flood flood = new Flood("John", "Boyd", 0, "test", medications, allergies );
        List<Flood> floodList = new ArrayList<>();
        floodList.add(flood);
        Flood flood1 = new Flood("Jacob", "Boyd", 0, "test", medications, allergies );
        List<Flood> floodList1 = new ArrayList<>();
        floodList1.add(flood1);

        Household household = new Household("1509 Culver St", floodList);
        Household household1 = new Household("1510 Culver St", floodList1);

        List<Household> householdList = new ArrayList<>();
        householdList.add(household);
        householdList.add(household1);

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress("2"));
        Assert.assertEquals(householdList.toString(), floodService.getHouseholdByStationAddress("2").toString());
    }

    // test the getHouseholdByStationAddress method from FloodService class when the station number doesn't match anything
    // it must return an empty List of Household
    @Test
    public void getFloodWithNoDataTest() {
        List<Person> personList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();
        List<Household> householdList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress("2"));
        Assert.assertEquals(householdList.toString(), floodService.getHouseholdByStationAddress("2").toString());
    }

    // test the getHouseholdByStationAddress method from FloodService class when the station number is incorrect
    // it must return an empty List of Household
    @Test
    public void getFloodWithIncorrectParamNumberTest() {
        List<Person> personList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();
        List<Household> householdList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(floodService.getHouseholdByStationAddress(""));
        Assert.assertEquals(householdList.toString(), floodService.getHouseholdByStationAddress("").toString());
    }

}
