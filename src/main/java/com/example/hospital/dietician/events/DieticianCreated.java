package com.example.hospital.dietician.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.values.Name;

public class DieticianCreated extends DomainEvent {
    private final Name name;


    public DieticianCreated(Name name) {
        super("com.example.hospital.dietician.trainercreated");
        this.name = name;
    }


    public Name getName() {
        return this.name;
    }
}
