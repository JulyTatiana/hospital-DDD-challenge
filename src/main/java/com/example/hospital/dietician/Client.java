package com.example.hospital.dietician;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.FitnessLevel;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.PhoneNumber;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private FitnessLevel fitnessLevel;
    private Name name;
    private PhoneNumber phoneNumber;
    public Client(ClientID entityId, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        super(entityId);
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }


    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public void updateFitnessLevel(FitnessLevel fitnessLevel) {
        this.fitnessLevel = Objects.requireNonNull(fitnessLevel);
    }

    public Name getName() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }
}
