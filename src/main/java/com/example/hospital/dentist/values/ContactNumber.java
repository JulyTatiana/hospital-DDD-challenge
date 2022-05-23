package com.example.hospital.dentist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class ContactNumber implements ValueObject<BigDecimal> {
    private final BigDecimal value;

    public ContactNumber(BigDecimal value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }
}