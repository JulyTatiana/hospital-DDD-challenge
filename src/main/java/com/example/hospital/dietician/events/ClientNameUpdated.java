package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.Name;

public class ClientNameUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Name name;

    public ClientNameUpdated(ClientID clientID, Name name) {
        super("com.example.hospital.dietician.clientnameupdated");
        this.clientID = clientID;
        this.name = name;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
