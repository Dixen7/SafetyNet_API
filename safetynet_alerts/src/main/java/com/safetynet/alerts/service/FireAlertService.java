package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FireAlertService {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    PersonRepository personRepository;

    public FireAlertService(PersonRepository personRepository, MedicalRecordService medicalRecordService, FirestationService firestationService) {
        this.personRepository = personRepository;
        this.medicalRecordService = medicalRecordService;
        this.firestationService = firestationService;
    }

    public List<FireAlert> getPersonsByAddress(String address) {
        List<FireAlert> fireAlertList = new ArrayList<>();
        List<Person> personList = personRepository.listPerson();

        for(Person person : personList) {
            if(person.getAddress().equals(address)) {
                FireAlert fireAlert = new FireAlert();
                fireAlert.setFirstName(person.getFirstName());
                fireAlert.setLastName(person.getLastName());
                fireAlert.setPhone(person.getPhone());
                fireAlert.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                fireAlert.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                fireAlert.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                fireAlert.setStationNumber(firestationService.getFireStationStationNumberByAddress(address));
                fireAlertList.add(fireAlert);
            }
        }
        return fireAlertList;
    }
}
