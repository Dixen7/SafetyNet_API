package com.safetynet.alerts.repository.Interface;


import com.safetynet.alerts.model.Firestation;

import java.util.List;

public interface IFirestationRepository {

    List<Firestation> firestationlist();

    void addAll(List<Firestation> firestations);

    void add(Firestation firestation);

    void update(Firestation firestation);

    void delete(Firestation firestation);
}