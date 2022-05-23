package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.IsCompleted;

public class DietPlanStateUpdated extends DomainEvent {
    private final IsCompleted isCompleted;

    public DietPlanStateUpdated(IsCompleted isCompleted) {
        super("com.example.hospital.dietician.routineiscompletedupdated");
        this.isCompleted = isCompleted;
    }

    public IsCompleted getIsCompleted() {
        return isCompleted;
    }
}
