package com.safetynet.alerts.repository;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.repository.Interface.IFirestationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FirestationRepository implements IFirestationRepository {

    private List<Firestation> firestations = new ArrayList<>();

    @Override
    public void addAll(List<Firestation> firestations) {
        this.firestations.addAll(firestations);
    }

    @Override
    public List<Firestation> firestationlist() {
        return firestations;
    }

    @Override
    public void add(Firestation firestation) {
        firestations.add(firestation);
    }

    @Override
    public void update(Firestation firestation) {
        for (Firestation f : firestations) {
            if (f.getAddress().equalsIgnoreCase(firestation.getAddress()) && f.getStation().equalsIgnoreCase(firestation.getStation())) {
                f.update(firestation);
                break;
            }
        }
    }

    @Override
    public void delete(Firestation firestation) {
        for (Firestation f : firestations) {
            if (f.getAddress().equalsIgnoreCase(firestation.getAddress()) && f.getStation().equalsIgnoreCase(firestation.getStation())) {
                firestations.remove(f);
                break;
            }
        }
    }
}