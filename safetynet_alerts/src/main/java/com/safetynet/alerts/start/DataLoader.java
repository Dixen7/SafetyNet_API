package com.safetynet.alerts.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.DataBase.DataStore;
import com.safetynet.alerts.repository.Interface.IFirestationRepository;
import com.safetynet.alerts.repository.Interface.IMedicalRecordRepository;
import com.safetynet.alerts.repository.Interface.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
@Order(1)
public class DataLoader implements CommandLineRunner {

    private final IPersonRepository personRepository;
    private final IMedicalRecordRepository medicalRecordRepository;
    private final IFirestationRepository firestationRepository;

    @Autowired
    public DataLoader(IPersonRepository personRepository, IFirestationRepository firestationRepository, IMedicalRecordRepository medicalRecordRepository) {
        this.personRepository = personRepository;
        this.firestationRepository = firestationRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.json");
        DataStore data = mapper.readValue(input, DataStore.class);
        personRepository.addAll(data.getPersons());
        firestationRepository.addAll(data.getFirestations());
        medicalRecordRepository.addAll(data.getMedicalrecords());
    }
}
