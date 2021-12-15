package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityEmailService {

    @Autowired
    PersonRepository personRepository;

    public CommunityEmailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<String> getEmailByCity(String city) {
        List<Person> personList = personRepository.listPerson();
        List<String> emailList = new ArrayList<>();

        for(Person person: personList) {
            if (person.getCity().equals(city)) {
                emailList.add(person.getEmail());
            }
        }
        return emailList;
    }
}
