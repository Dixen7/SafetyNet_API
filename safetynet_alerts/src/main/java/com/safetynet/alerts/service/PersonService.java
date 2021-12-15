package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> add(Person person) {
        List<Person> listPersons = personRepository.listPerson();
        listPersons.add(person);
        return listPersons;
    }

    public List<Person> update(Person person) {
        String firstname = person.getFirstName();
        String lastName = person.getLastName();

        List<Person> listPersons = personRepository.listPerson();

        for (Person p : listPersons) {
            if (p.getFirstName().equals(firstname) && p.getLastName().equals(lastName)) {
                p.setAddress(person.getAddress());
                p.setCity(person.getCity());
                p.setZip(person.getZip());
                p.setPhone(person.getPhone());
                p.setEmail(person.getEmail());
            }
        }
        return listPersons;

    }

    public List<Person> delete(String firstName, String lastName) {
        List<Person> listPersons = personRepository.listPerson();

        listPersons.removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
        return listPersons;
    }
}
