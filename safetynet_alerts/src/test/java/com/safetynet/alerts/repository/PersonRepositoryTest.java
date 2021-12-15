package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    void updatePersonTest() {
        Person person = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
                "jaboyd@email.com");
        Person johnUpdate = new Person();

        personRepository.update(person);
        johnUpdate.update(person);

        assertEquals(person.getEmail(), johnUpdate.getEmail());
        assertEquals(person.getCity(), johnUpdate.getCity());
    }

    @Test
    void test_addPerson() {
        Person person = new Person("firstname", "lastname", "adress", "city", "97451", "841-874-6512",
                "mail@email.com");

        personRepository.add(person);
        assertEquals(personRepository.listPerson().contains(person), true);
    }

    @Test
    void test_removePerson() {
        Person person = new Person("firstname", "lastname", "adress", "city", "97451", "841-874-6512",
                "mail@email.com");

        personRepository.add(person);
        personRepository.delete(person);
        assertEquals(personRepository.listPerson().contains(person), false);
    }

}
