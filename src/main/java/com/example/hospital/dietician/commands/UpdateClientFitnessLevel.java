package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.FitnessLevel;
import com.example.hospital.dietician.values.DieticianID;

public class UpdateClientFitnessLevel extends Command {
    private final DieticianID dieticianID;
    private  final ClientID clientID;
    private final FitnessLevel fitnessLevel;

    public UpdateClientFitnessLevel(DieticianID dieticianID, ClientID clientID, FitnessLevel fitnessLevel) {
        this.dieticianID = dieticianID;
        this.clientID = clientID;
        this.fitnessLevel = fitnessLevel;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }
}
