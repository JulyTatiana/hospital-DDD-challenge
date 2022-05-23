package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.DieticianID;

public class UpdateClientName extends Command {
    private final DieticianID dieticianID;
    private final ClientID clientID;
    private final Name name;

    public UpdateClientName(DieticianID dieticianID, ClientID clientID, Name name) {
        this.dieticianID = dieticianID;
        this.clientID = clientID;
        this.name = name;
    }

    public DieticianID getDieticianID() {
        return dieticianID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public Name getName() {
        return name;
    }
}
