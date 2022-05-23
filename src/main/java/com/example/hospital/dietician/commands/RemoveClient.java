package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.DieticianID;

public class RemoveClient extends Command {
    private final DieticianID dieticianID;
    private final ClientID clientID;

    public RemoveClient(DieticianID dieticianID, ClientID clientID) {
        this.dieticianID = dieticianID;
        this.clientID = clientID;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
