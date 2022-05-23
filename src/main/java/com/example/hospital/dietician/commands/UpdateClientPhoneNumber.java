package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.ClientID;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.PhoneNumber;

public class UpdateClientPhoneNumber extends Command {
    private final DieticianID dieticianID;
    private final ClientID clientID;
    private final PhoneNumber phoneNumber;

    public UpdateClientPhoneNumber(DieticianID dieticianID, ClientID clientID, PhoneNumber phoneNumber) {
        this.dieticianID = dieticianID;
        this.clientID = clientID;
        this.phoneNumber = phoneNumber;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public ClientID getClientID() {
        return clientID;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
