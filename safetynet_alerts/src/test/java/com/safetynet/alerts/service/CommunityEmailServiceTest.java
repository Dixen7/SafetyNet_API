package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommunityEmailServiceTest {

    private static CommunityEmailService communityEmailService;

    private static PersonRepository personRepository;

    @BeforeAll
    private static void setup() {
        personRepository = mock(PersonRepository.class);
        communityEmailService = new CommunityEmailService(personRepository);
    }

    // test the getEmailByCity method from the CommunityEmailService class
    // it must return a List of email
    @Test
    public void getEmailList() {
        List<Person> personList = new ArrayList<>();

        Person person = new Person();
        person.setEmail("test@testmail.com");
        person.setCity("Culver");
        personList.add(person);

        Person person1 = new Person();
        person1.setEmail("test2@testmail.com");
        person1.setCity("Culver");
        personList.add(person1);

        List<String> emailList = new ArrayList<>();
        emailList.add("test@testmail.com");
        emailList.add("test2@testmail.com");

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(communityEmailService.getEmailByCity("Culver"));
        Assert.assertEquals(emailList.toString(), communityEmailService.getEmailByCity("Culver").toString());
    }

    // test the getEmailByCity method from the CommunityEmailService class when there is no email associated with the city
    // it must return an empty List of email
    @Test
    public void getEmailListWithNoEmailInTheCity() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setEmail("test@testmail.com");
        person.setCity("Culver");
        personList.add(person);

        Person person1 = new Person();
        person1.setEmail("test2@testmail.com");
        person1.setCity("Culver");
        personList.add(person1);

        List<String> emailList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(communityEmailService.getEmailByCity("Culve"));
        Assert.assertEquals(emailList.toString(), communityEmailService.getEmailByCity("Culve").toString());
    }

    // test the getEmailByCity method from the CommunityEmailService class when the city is incorrect
    // it must return an empty List of email
    @Test
    public void getEmailListWithIncorrectParam() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        person.setEmail("test@testmail.com");
        person.setCity("Culver");
        personList.add(person);

        Person person1 = new Person();
        person1.setEmail("test2@testmail.com");
        person1.setCity("Culver");
        personList.add(person1);

        List<String> emailList = new ArrayList<>();

        when(personRepository.listPerson()).thenReturn(personList);

        Assert.assertNotNull(communityEmailService.getEmailByCity(""));
        Assert.assertEquals(emailList.toString(), communityEmailService.getEmailByCity("").toString());
    }
}
