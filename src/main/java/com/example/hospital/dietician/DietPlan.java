package com.example.hospital.dietician;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dietician.values.Description;
import com.example.hospital.dietician.values.DietPlanID;
import com.example.hospital.dietician.values.IsCompleted;
import com.example.hospital.dietician.values.Type;

import java.util.Objects;

public class DietPlan extends Entity<DietPlanID> {

    private Description description;
    private Type type;
    private IsCompleted isCompleted;
    public DietPlan(DietPlanID entityId, Description description, Type type) {
        super(entityId);
        this.description = description;
        this.type = type;
        this.isCompleted = new IsCompleted(false);
    }


    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public IsCompleted isCompleted() {
        return isCompleted;
    }

    public void updateIsCompleted(IsCompleted isCompleted) {
        this.isCompleted = Objects.requireNonNull(isCompleted);
    }

    public Type type() {
        return type;
    }

    public void updateType(Type type) {
        this.type = Objects.requireNonNull(type);
    }
}
