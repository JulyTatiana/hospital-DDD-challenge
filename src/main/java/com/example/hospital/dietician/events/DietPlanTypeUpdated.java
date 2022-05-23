package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Type;

public class DietPlanTypeUpdated extends DomainEvent {
    private final Type type;

    public DietPlanTypeUpdated(Type type) {
        super("com.zen.gymdomain.dietician.routinetypeupdated");
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
