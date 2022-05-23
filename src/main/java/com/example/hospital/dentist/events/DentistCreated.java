package com.example.hospital.dentist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Name;

public class DentistCreated extends DomainEvent {

    private final Name name;

    public DentistCreated(Name name) {
        super("com.example.hospital.dentist.dentistcreated");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
