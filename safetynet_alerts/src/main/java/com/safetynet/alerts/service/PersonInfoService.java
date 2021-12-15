package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.PersonInfo;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInfoService {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    PersonRepository personRepository;

    public PersonInfoService(PersonRepository personRepository, MedicalRecordService medicalRecordService) {
        this.personRepository = personRepository;
        this.medicalRecordService = medicalRecordService;
    }

    public List<PersonInfo> getPersonInformation(String firstName, String lastName) {
        List<Person> personList = personRepository.listPerson();
        List<PersonInfo> personInfoList = new ArrayList<>();

        for(Person person : personList) {
            if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                PersonInfo pi = new PersonInfo();
                pi.setFirstName(person.getFirstName());
                pi.setLastName(person.getLastName());
                pi.setAddress(person.getAddress());
                pi.setEmail(person.getEmail());
                pi.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                pi.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                pi.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                personInfoList.add(pi);
            }
        }
        return personInfoList;
    }
}
