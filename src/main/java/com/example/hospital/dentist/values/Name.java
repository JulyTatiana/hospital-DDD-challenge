package com.example.hospital.dentist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return this.value;
    }
}
