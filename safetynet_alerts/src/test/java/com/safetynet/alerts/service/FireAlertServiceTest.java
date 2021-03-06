package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireAlert;
import com.safetynet.alerts.model.Person;
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

public class FireAlertServiceTest {

    private static FireAlertService fireAlertService;
    private static PersonRepository personRepository;
    private static MedicalRecordRepository medicalRecordRepository;
    private static FirestationRepository firestationRepository;

    @BeforeAll
    private static void setup() {
        personRepository = mock(PersonRepository.class);
        firestationRepository = mock(FirestationRepository.class);
        medicalRecordRepository = mock(MedicalRecordRepository.class);
        MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordRepository);
        FirestationService firestationService = new FirestationService(personRepository, firestationRepository, medicalRecordService);
        fireAlertService = new FireAlertService(personRepository, medicalRecordService, firestationService);
    }

    // test the getPersonsByAddress method from the FireAlertService class
    // it must return a List of FireAlert
    @Test
    public void getFireAlertTest() {

        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Boyd");
        person.setAddress("1509 Culver St");
        person.setPhone("test");
        personList.add(person);

        Person person2 = new Person();
        person2.setFirstName("Tenley");
        person2.setLastName("Boyd");
        person2.setAddress("1510 Culver St");
        personList.add(person2);

        List<FireAlert> fireAlertList = new ArrayList<>();
        List<String> medications = new ArrayList<>();
        List<String> allergies = new ArrayList<>();
        List<String> stationNumber = new ArrayList<>();
        FireAlert fireAlert = new FireAlert("John", "Boyd", 0, "test", medications, allergies, stationNumber);
        fireAlertList.add(fireAlert);

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress("1509 Culver St"));
        Assert.assertEquals(fireAlertList.toString(), fireAlertService.getPersonsByAddress("1509 Culver St").toString());
    }

    // test the getPersonsByAddress method from the FireAlertService class when there is no data linked to the address
    // it must return an empty List of FireAlert
    @Test
    public void getFireAlertWithNoData() {
        List<Person> personList = new ArrayList<>();
        List<FireAlert> fireAlertList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress("1509 Culver St"));
        Assert.assertEquals(fireAlertList.toString(), fireAlertService.getPersonsByAddress("1509 Culver St").toString());
    }

    // test the getPersonsByAddress method from the FireAlertService class when the address is incorrect
    // it must return an empty List of FireAlert
    @Test
    public void getFireAlertWithNoAddress() {
        List<Person> personList = new ArrayList<>();
        List<FireAlert> fireAlertList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(fireAlertService.getPersonsByAddress(""));
        Assert.assertEquals(fireAlertList.toString(), fireAlertService.getPersonsByAddress("").toString());
    }
}
