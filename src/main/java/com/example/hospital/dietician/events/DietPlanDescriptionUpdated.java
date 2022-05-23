package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Description;

public class DietPlanDescriptionUpdated extends DomainEvent {
    private final Description description;

    public DietPlanDescriptionUpdated(Description description) {
        super("com.example.hospital.dietician.routinedescriptionupdated");
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }
}
