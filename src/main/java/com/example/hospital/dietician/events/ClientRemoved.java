package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;

public class ClientRemoved extends DomainEvent {
    private final ClientID clientID;
    private final Boolean wasDeleted;

    public ClientRemoved(ClientID clientID) {
        super("com.zen.gymdomain.dietician.clientremoved");
        this.clientID = clientID;
        this.wasDeleted = true;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Boolean getWasDeleted() {
        return wasDeleted;
    }
}
