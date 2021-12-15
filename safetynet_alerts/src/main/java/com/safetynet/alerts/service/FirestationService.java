package com.safetynet.alerts.service;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.repository.FirestationRepository;
import com.safetynet.alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FirestationService {

    @Autowired
    FirestationRepository firestationRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MedicalRecordService medicalRecordService;

    public FirestationService(PersonRepository personRepository, FirestationRepository firestationRepository, MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
        this.firestationRepository = firestationRepository;
        this.personRepository = personRepository;
    }

    public List<Firestation> add(Firestation firestation) {
        List<Firestation> listFirestations = firestationRepository.firestationlist();
        listFirestations.add(firestation);
        return listFirestations;
    }

    public List<Firestation> update(Firestation firestation) {

        String address = firestation.getAddress();
        String station = firestation.getStation();
        List<Firestation> listFirestations = firestationRepository.firestationlist();

        for (Firestation fs : listFirestations) {
            if (fs.getAddress().equals(address)) {
                fs.setStation(station);
            }
        }
        return listFirestations;
    }

    public List<Firestation> delete(String address) {
        List<Firestation> listFirestations = firestationRepository.firestationlist();

        listFirestations.removeIf(firestation -> firestation.getAddress().equals(address));
        return listFirestations;
    }

    public List<StationCoverage> getPersonsCoverageByStationNumber(String stationNumber) {
        List<Person> personList = personRepository.listPerson();
        List<PersonCovered> personCoveredList = new ArrayList<>();
        List<StationCoverage> stationCoverageList = new ArrayList<>();
        int adult = 0;
        int child = 0;

        for( Person person : personList) {
            if(getFireStationAddressByStationNumber(stationNumber).contains(person.getAddress())) {
                PersonCovered personCovered = new PersonCovered();
                personCovered.setFirstName(person.getFirstName());
                personCovered.setLastName(person.getLastName());
                personCovered.setAddress(person.getAddress());
                personCovered.setPhone(person.getPhone());
                personCoveredList.add(personCovered);
                if (medicalRecordService.getAge(personCovered.getFirstName(), personCovered.getLastName()) <= 18) {
                    child++;
                } else {
                    adult++;
                }
            }
        }
        if (!personCoveredList.isEmpty()) {
            StationCoverage stationCoverage = new StationCoverage(adult, child, personCoveredList);
            stationCoverageList.add(stationCoverage);
        }
        return stationCoverageList;
    }

    public List<String> getFireStationAddressByStationNumber(String stationNumber) {
        List<Firestation> firestationList = firestationRepository.firestationlist();
        List<String> fireStationAddressList = new ArrayList<>();

        for (Firestation fs : firestationList) {
            if (fs.getStation().equals(stationNumber)) {
                String address = fs.getAddress();
                fireStationAddressList.add(address);
            }
        }
        return fireStationAddressList;
    }

    public List<String> getFireStationStationNumberByAddress(String address) {
        List<Firestation> firestationList = firestationRepository.firestationlist();
        List<String> fireStationAddressList = new ArrayList<>();

        for (Firestation fs : firestationList) {
            if (fs.getAddress().equals(address)) {
                String station = fs.getStation();
                fireStationAddressList.add(station);
            }
        }
        return fireStationAddressList;
    }
}