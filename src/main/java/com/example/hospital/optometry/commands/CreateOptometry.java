package com.example.hospital.optometry.commands;

import co.com.sofka.domain.generic.Command;
import com.example.hospital.optometry.values.OptometryID;
import com.example.hospital.dietician.values.Name;

public class CreateOptometry extends Command {


    private final OptometryID entityId;
    private final Name name;

    public CreateOptometry(OptometryID entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public OptometryID getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
