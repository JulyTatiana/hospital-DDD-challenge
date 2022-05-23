package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.State;

public class UpdateDietPlanState extends Command {
    private final DieticianID dieticianID;
    private final State state;

    public UpdateDietPlanState(DieticianID dieticianID, State state) {
        this.dieticianID = dieticianID;
        this.state = state;
    }

    public DieticianID getDieticianID() {
        return dieticianID;
    }

    public State getState() {
        return state;
    }
}
