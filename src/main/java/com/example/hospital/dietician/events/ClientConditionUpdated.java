package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.Condition;

public class ClientConditionUpdated extends DomainEvent {
    private final ClientID clientID;
    private final Condition condition;

    public ClientConditionUpdated(ClientID clientID, Condition condition) {
        super("com.example.hospital.dietician.clientconditionupdated");

        this.clientID = clientID;
        this.condition = condition;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Condition getCondition() {
        return condition;
    }
}
