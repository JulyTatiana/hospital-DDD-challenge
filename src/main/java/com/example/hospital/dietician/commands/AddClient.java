package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.FitnessLevel;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.PhoneNumber;

public class AddClient extends Command {
    private final DieticianID dieticianID;
    private final Name name;
    private final FitnessLevel fitnessLevel;
    private final PhoneNumber phoneNumber;

    public AddClient(DieticianID dieticianID, Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        this.dieticianID = dieticianID;
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public Name getName() {
        return name;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
