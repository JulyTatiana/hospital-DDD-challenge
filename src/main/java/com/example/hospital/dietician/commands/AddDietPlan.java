package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.Description;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.Type;

public class AddDietPlan extends Command {
    private final DieticianID dieticianID;
    private final Description description;
    private final Type type;

    public AddDietPlan(DieticianID dieticianID, Description description, Type type) {
        this.dieticianID = dieticianID;
        this.description = description;
        this.type = type;
    }

    public DieticianID getDieticianID() {
        return dieticianID;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }
}
