package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.PhoneNumber;

public class ClientPhoneNumberUpdated extends DomainEvent {
    private final ClientID clientID;
    private final PhoneNumber phoneNumber;

    public ClientPhoneNumberUpdated(ClientID clientID, PhoneNumber phoneNumber) {
        super("com.example.dietician.clientphonenumberupdated");
        this.clientID = clientID;
        this.phoneNumber = phoneNumber;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
