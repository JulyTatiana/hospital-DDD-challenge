package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Description;
import com.example.hospital.dietician.values.DietPlanID;
import com.example.hospital.dietician.values.Type;

public class DietPlanAdded extends DomainEvent {

    private final DietPlanID dietPlanID;
    private final Description description;
    private final Type type;

    public DietPlanAdded(DietPlanID dietPlanID, Description description, Type type) {
        super("com.zen.gymdomain.dietician.routineadded");
        this.dietPlanID = dietPlanID;
        this.description = description;
        this.type = type;
    }

    public DietPlanID getRoutineID() {
        return dietPlanID;
    }

    public Description getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }
}
