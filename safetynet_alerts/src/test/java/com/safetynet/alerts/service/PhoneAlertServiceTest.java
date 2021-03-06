package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Firestation;
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

public class PhoneAlertServiceTest {

    private static PhoneAlertService phoneAlertService;
    private static MedicalRecordService medicalRecordService;
    private static PersonRepository personRepository;
    private static FirestationRepository firestationRepository;
    private static MedicalRecordRepository medicalRecordRepository;

    @BeforeAll
    private static void setup() {
        personRepository = mock(PersonRepository.class);
        firestationRepository = mock(FirestationRepository.class);
        FirestationService firestationService = new FirestationService(personRepository, firestationRepository, medicalRecordService);
        phoneAlertService = new PhoneAlertService(personRepository, firestationService);
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class
    // it must return a List of string
    @Test
    public void getPhoneNumberListTest() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        personList.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        personList.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        personList.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        personList.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        personList.add(person5);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);

        List<String> phoneList = new ArrayList<>();
        phoneList.add("testphone1");
        phoneList.add("testphone2");
        phoneList.add("testphone3");
        phoneList.add("testphone4");
        phoneList.add("testphone5");

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage("2"));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("2").toString());
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class when the parameters doesn't match with anything
    // it must return an empty List of string
    @Test
    public void getPhoneNumberListWithNoDataTest() {
        List<Person> personList = new ArrayList<>();
        List<String> phoneList = new ArrayList<>();

        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        personList.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        personList.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        personList.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        personList.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        personList.add(person5);

        List<Firestation> firestationList = new ArrayList<>();
        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);
        firestationList.add(firestation);

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage("1"));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("1").toString());
    }

    // test the getPhoneNumberByCoverage method from the PhoneAlertService class when the parameters are incorrect
    // it must return an empty List of string
    @Test
    public void getPhoneNumberListWithIncorrectParamTest() {
        List<Person> personList = new ArrayList<>();
        List<String> phoneList = new ArrayList<>();
        List<Firestation> firestationList = new ArrayList<>();

        Person person1 = new Person();
        person1.setAddress("1510 Culver St");
        person1.setPhone("testphone1");
        personList.add(person1);

        Person person2 = new Person();
        person2.setAddress("1509 Culver St");
        person2.setPhone("testphone2");
        personList.add(person2);

        Person person3 = new Person();
        person3.setAddress("1509 Culver St");
        person3.setPhone("testphone3");
        personList.add(person3);

        Person person4 = new Person();
        person4.setAddress("1509 Culver St");
        person4.setPhone("testphone4");
        personList.add(person4);

        Person person5 = new Person();
        person5.setAddress("1509 Culver St");
        person5.setPhone("testphone5");
        personList.add(person5);

        Firestation firestation = new Firestation();
        firestation.setStation("2");
        firestation.setAddress("1509 Culver St");
        firestationList.add(firestation);

        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("1510 Culver St");
        firestationList.add(firestation1);
        firestationList.add(firestation);

        when(personRepository.listPerson()).thenReturn(personList);
        when(firestationRepository.firestationlist()).thenReturn(firestationList);

        Assert.assertNotNull(phoneAlertService.getPhoneNumberByCoverage(""));
        Assert.assertEquals(phoneList.toString(), phoneAlertService.getPhoneNumberByCoverage("").toString());
    }

}
