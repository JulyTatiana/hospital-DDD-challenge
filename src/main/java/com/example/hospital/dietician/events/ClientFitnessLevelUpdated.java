package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.FitnessLevel;

public class ClientFitnessLevelUpdated extends DomainEvent {
    private final ClientID clientID;
    private final FitnessLevel fitnessLevel;

    public ClientFitnessLevelUpdated(ClientID clientID, FitnessLevel fitnessLevel) {
        super("com.example.hospital.dietician.clientfitnesslevelupdated");

        this.clientID = clientID;
        this.fitnessLevel = fitnessLevel;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }
}
