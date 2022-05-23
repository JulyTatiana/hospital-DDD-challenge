package com.example.hospital.optometry.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Name;

public class OptometryCreated extends DomainEvent {

    private final Name name;

    public OptometryCreated(Name name) {
        super("com.zen.gymdomain.optometry.frontdeskcreated");
        this.name = name;
    }


    public Name getName() {
        return name;
    }
}
