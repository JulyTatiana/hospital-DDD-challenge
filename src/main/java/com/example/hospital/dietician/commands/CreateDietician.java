package com.example.hospital.dietician.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.dietician.values.DieticianID;
import com.example.hospital.dietician.values.Name;

public class CreateDietician extends Command {
    private final DieticianID entityId;
    private final Name name;

    public CreateDietician(DieticianID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public DieticianID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
