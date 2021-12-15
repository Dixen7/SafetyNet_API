package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.Interface.IPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {

    private List<Person> persons = new ArrayList<>();

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public List<Person> listPerson() {
        return persons;
    }

    @Override
    public void addAll(List<Person> persons) {
        this.persons.addAll(persons);
    }

    @Override
    public void add(Person person) {
        persons.add(person);
    }

    @Override
    public void update(Person person) {
        for (Person p : persons) {
            if (p.getFirstName().equalsIgnoreCase(person.getFirstName()) && p.getLastName().equalsIgnoreCase(person.getLastName())) {
                p.update(person);
                break;
            }
        }
    }

    @Override
    public void delete(Person person) {
        for (Person p : persons) {
            if (p.getFirstName().equalsIgnoreCase(person.getFirstName()) && p.getLastName().equalsIgnoreCase(person.getLastName())) {
                persons.remove(p);
                break;
            }
        }
    }
}