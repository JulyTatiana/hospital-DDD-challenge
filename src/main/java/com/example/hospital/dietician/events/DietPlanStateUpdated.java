package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.State;

public class DietPlanStateUpdated extends DomainEvent {
    private final State state;

    public DietPlanStateUpdated(State state) {
        super("com.example.hospital.dietician.routineiscompletedupdated");
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
