package com.example.hospital.dentist;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dentist.values.DietID;
import com.example.hospital.dentist.values.DietType;
import com.example.hospital.dietician.values.Description;

import java.util.Objects;

public class Diet extends Entity<DietID> {
    protected DietType dietType;
    protected Description description;

    public Diet(DietID entityId, DietType dietType, Description description) {
        super(entityId);
        this.dietType = dietType;
        this.description = description;
    }

    public DietType dietType() {
        return dietType;
    }

    public void updateDietType(DietType dietType) {
        this.dietType = Objects.requireNonNull(dietType);
    }

    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }
}
