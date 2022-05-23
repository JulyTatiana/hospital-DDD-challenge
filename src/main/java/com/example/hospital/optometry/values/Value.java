package com.example.hospital.optometry.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Value implements ValueObject<ValueEnum> {
    private final ValueEnum value;

    public Value(ValueEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public ValueEnum value() {
        return this.value;
    }
}

enum ValueEnum {
    ASTIGMATISMO,
    MIOPIA,
    HIPERMETROPIA
}
