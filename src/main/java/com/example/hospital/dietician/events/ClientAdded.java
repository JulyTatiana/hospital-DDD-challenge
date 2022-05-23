package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.PhoneNumber;
import com.example.hospital.dietician.values.Condition;
import com.example.hospital.dietician.values.Name;

public class ClientAdded extends DomainEvent {

    private final ClientID clientID;
    private final Name name;
    private final Condition condition;
    private final PhoneNumber phoneNumber;

    public ClientAdded(ClientID clientID, Name name, Condition condition, PhoneNumber phoneNumber) {
        super("com.example.hospital.dietician.clientadded");
        this.clientID = clientID;
        this.name = name;
        this.condition = condition;
        this.phoneNumber = phoneNumber;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }

    public Condition getCondition() {
        return condition;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
