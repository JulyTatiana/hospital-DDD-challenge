package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.PhoneNumber;
import com.example.hospital.dietician.values.FitnessLevel;
import com.example.hospital.dietician.values.Name;

public class ClientAdded extends DomainEvent {

    private final ClientID clientID;
    private final Name name;
    private final FitnessLevel fitnessLevel;
    private final PhoneNumber phoneNumber;

    public ClientAdded(ClientID clientID, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        super("com.example.hospital.dietician.clientadded");
        this.clientID = clientID;
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
