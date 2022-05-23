package com.example.hospital.dietician;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.Condition;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.PhoneNumber;

import java.util.Objects;

public class Client extends Entity<ClientID> {

    private Condition condition;
    private Name name;
    private PhoneNumber phoneNumber;
    public Client(ClientID entityId, Name name, Condition condition, PhoneNumber phoneNumber) {
        super(entityId);
        this.name = name;
        this.condition = condition;
        this.phoneNumber = phoneNumber;
    }


    public Condition getFitnessLevel() {
        return condition;
    }

    public void updateFitnessLevel(Condition condition) {
        this.condition = Objects.requireNonNull(condition);
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
