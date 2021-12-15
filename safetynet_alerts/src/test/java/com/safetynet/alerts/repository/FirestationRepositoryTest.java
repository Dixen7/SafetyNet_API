package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.Firestation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
class FirestationRepositoryTest {

    @Autowired
    FirestationRepository firestationRepository;

    @Test
    void updateFirestationTest() {
        Firestation firestation = new Firestation();
        String addressBase = "Addresse base";
        String stationBase = "Station base";
        firestation.setAddress(addressBase);
        firestation.setStation(stationBase);
        Firestation firestationUpdate = new Firestation();

        firestationUpdate.update(firestation);
        firestationRepository.update(firestation);

        assertEquals(firestation.getAddress(), firestationUpdate.getAddress());
        assertEquals(firestation.getStation(), firestationUpdate.getStation());
    }

    @Test
    void test_addFirestation() {

        Firestation fs = new Firestation();
        String addressBase = "Addresse base";
        String stationBase = "Station base";
        fs.setAddress(addressBase);
        fs.setStation(stationBase);
        firestationRepository.add(fs);
        assertEquals(firestationRepository.firestationlist().contains(fs), true);
    }

    @Test
    void test_removeFirestation() {

        Firestation fs = new Firestation();
        String addressBase = "Addresse base";
        String stationBase = "Station base";
        fs.setAddress(addressBase);
        fs.setStation(stationBase);

        firestationRepository.delete(fs);
        assertEquals(firestationRepository.firestationlist().contains(fs), false);
    }
}
