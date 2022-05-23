package com.example.hospital.dentist;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.dentist.values.TreatmentID;
import com.example.hospital.dentist.values.TreatmentType;
import com.example.hospital.dietician.values.Description;

import java.util.Objects;

public class Treatment extends Entity<TreatmentID> {
    protected TreatmentType treatmentType;
    protected Description description;

    public Treatment(TreatmentID entityId, TreatmentType treatmentType, Description description) {
        super(entityId);
        this.treatmentType = treatmentType;
        this.description = description;
    }

    public TreatmentType dietType() {
        return treatmentType;
    }

    public void updateTreatmentType(TreatmentType treatmentType) {
        this.treatmentType = Objects.requireNonNull(treatmentType);
    }

    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }
}
