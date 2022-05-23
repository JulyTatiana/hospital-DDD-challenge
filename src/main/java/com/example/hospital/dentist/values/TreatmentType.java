package com.example.hospital.dentist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TreatmentType implements ValueObject<TreatmentTypeEnum> {
    private final TreatmentTypeEnum treatmentTypeEnum;

    public TreatmentType(TreatmentTypeEnum treatmentTypeEnum) {
        this.treatmentTypeEnum = Objects.requireNonNull(treatmentTypeEnum);
    }


    @Override
    public TreatmentTypeEnum value() {
        return this.treatmentTypeEnum;
    }
}

enum TreatmentTypeEnum {
    CLEANING,
    ORTHODONTICS,
    WHITENING
}
