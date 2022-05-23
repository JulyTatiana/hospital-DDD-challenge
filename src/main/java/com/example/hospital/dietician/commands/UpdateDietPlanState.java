package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.IsCompleted;

public class UpdateDietPlanState extends Command {
    private final DieticianID dieticianID;
    private final IsCompleted isCompleted;

    public UpdateDietPlanState(DieticianID dieticianID, IsCompleted isCompleted) {
        this.dieticianID = dieticianID;
        this.isCompleted = isCompleted;
    }

    public DieticianID getTrainerID() {
        return dieticianID;
    }

    public IsCompleted getIsCompleted() {
        return isCompleted;
    }
}
