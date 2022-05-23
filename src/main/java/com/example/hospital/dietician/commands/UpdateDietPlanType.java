package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.Type;

public class UpdateDietPlanType extends Command {
    private final DieticianID dieticianID;
    private final Type type;

    public UpdateDietPlanType(DieticianID dieticianID, Type type) {
        this.dieticianID = dieticianID;
        this.type = type;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public Type getType() {
        return type;
    }
}
