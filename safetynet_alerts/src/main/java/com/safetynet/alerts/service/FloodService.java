package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Flood;
import com.safetynet.alerts.model.Household;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloodService {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    FirestationService firestationService;

    @Autowired
    PersonRepository personRepository;

    public FloodService(PersonRepository personRepository, MedicalRecordService medicalRecordService, FirestationService firestationService) {
        this.personRepository = personRepository;
        this.medicalRecordService = medicalRecordService;
        this.firestationService = firestationService;
    }

    public List<Household> getHouseholdByStationAddress(String stationNumber) {
        List<String> stationAddressList = firestationService.getFireStationAddressByStationNumber(stationNumber);
        List<Person> personList = personRepository.listPerson();
        List<Household> householdsList = new ArrayList<>();

        for(String address: stationAddressList) {
            List<Flood> floodList = new ArrayList<>();
            for(Person person: personList) {
                if (person.getAddress().equals(address)){
                    Flood flood = new Flood();
                    flood.setFirstName(person.getFirstName());
                    flood.setLastName(person.getLastName());
                    flood.setPhone(person.getPhone());
                    flood.setAge(medicalRecordService.getAge(person.getFirstName(), person.getLastName()));
                    flood.setMedications(medicalRecordService.getMedications(person.getFirstName(), person.getLastName()));
                    flood.setAllergies(medicalRecordService.getAllergies(person.getFirstName(), person.getLastName()));
                    floodList.add(flood);
                }
            }
            Household household = new Household(address, floodList);
            householdsList.add(household);
        }
        return householdsList;
    }

}
