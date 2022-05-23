package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.Description;
import com.example.hospital.dietician.values.DieticianID;

public class UpdateDietPlanDescription extends Command {
    private final DieticianID dieticianID;
    private final Description description;

    public UpdateDietPlanDescription(DieticianID dieticianID, Description description) {
        this.dieticianID = dieticianID;
        this.description = description;
    }

    public DieticianID getDieticianID() {
        return dieticianID;
    }

    public Description getDescription() {
        return description;
    }
}

