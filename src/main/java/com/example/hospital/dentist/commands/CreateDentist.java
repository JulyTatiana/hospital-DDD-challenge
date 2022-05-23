package com.example.hospital.dentist.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dentist.values.DentistID;
import com.example.hospital.dietician.values.Name;

public class CreateDentist extends Command {
    private final DentistID entityId;
    private final Name name;

    public CreateDentist(DentistID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public DentistID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
