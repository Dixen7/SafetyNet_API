package com.safetynet.alerts.repository.Interface;

import com.safetynet.alerts.model.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> listPerson();

    void addAll(List<Person> persons);

    void add(Person person);

    void update(Person person);

    void delete(Person person);
}