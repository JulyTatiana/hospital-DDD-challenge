package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.Condition;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.PhoneNumber;

public class AddClient extends Command {
    private final DieticianID dieticianID;
    private final Name name;
    private final Condition condition;
    private final PhoneNumber phoneNumber;

    public AddClient(DieticianID dieticianID, Name name, Condition condition, PhoneNumber phoneNumber) {
        this.dieticianID = dieticianID;
        this.name = name;
        this.condition = condition;
        this.phoneNumber = phoneNumber;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public Name getName() {
        return name;
    }

    public Condition getFitnessLevel() {
        return condition;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
