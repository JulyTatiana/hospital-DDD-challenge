package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.Condition;
import com.example.hospital.dietician.values.DieticianID;

public class UpdateClientCondition extends Command {
    private final DieticianID dieticianID;
    private  final ClientID clientID;
    private final Condition condition;

    public UpdateClientCondition(DieticianID dieticianID, ClientID clientID, Condition condition) {
        this.dieticianID = dieticianID;
        this.clientID = clientID;
        this.condition = condition;
    }

    public DieticianID getDieticianID() {
        return dieticianID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Condition getCondition() {
        return condition;
    }
}
