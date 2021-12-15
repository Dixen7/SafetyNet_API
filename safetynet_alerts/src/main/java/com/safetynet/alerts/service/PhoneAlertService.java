package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneAlertService {


    @Autowired
    FirestationService firestationService;

    @Autowired
    PersonRepository personRepository;

    public PhoneAlertService( PersonRepository personRepository, FirestationService firestationService) {
        this.personRepository = personRepository;
        this.firestationService = firestationService;
    }

    public List<String> getPhoneNumberByCoverage(String firestation_number) {
        List<Person> personList = personRepository.listPerson();
        List<String> phoneNumberList = new ArrayList<>();

        for(Person person : personList) {
            if(firestationService.getFireStationAddressByStationNumber(firestation_number).contains(person.getAddress())) {
                phoneNumberList.add(person.getPhone());
            }
        }
        return phoneNumberList;
    }
}
