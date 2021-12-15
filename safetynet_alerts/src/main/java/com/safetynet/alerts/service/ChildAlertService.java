package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;
import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ChildAlertService {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    PersonRepository personRepository;

    public ChildAlertService(PersonRepository personRepository, MedicalRecordService medicalRecordService) {
        this.personRepository = personRepository;
        this.medicalRecordService = medicalRecordService;
    }

    public List<ChildAlert> getChildByAddress(String address) {
        List<Person> personList = personRepository.listPerson();
        List<String> family = new ArrayList<>();
        List<ChildAlert> childAlertList = new ArrayList<>();


        for(Person person: personList) {
            if(person.getAddress().equals(address)) {
                int age = medicalRecordService.getAge(person.getFirstName(), person.getLastName());
                if(age <= 18) {
                    ChildAlert childAlert = new ChildAlert();
                    childAlert.setFirstName(person.getFirstName());
                    childAlert.setLastName(person.getLastName());
                    childAlert.setAge(age);
                    childAlert.setFamily(family);
                    childAlertList.add(childAlert);
                } else {
                    String fusion = person.getFirstName() + " " + person.getLastName();
                    family.add(fusion);
                }
            }
        }
        return childAlertList;
    }
}
