package com.example.hospital.optometry;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.optometry.values.ServiceID;
import com.example.hospital.optometry.values.Price;
import com.example.hospital.optometry.values.Value;

import java.util.Objects;

public class Service extends Entity<ServiceID> {
    protected Value value;
    protected Price price;
    public Service(ServiceID entityId, Value value, Price price) {
        super(entityId);
        this.value = value;
        this.price = price;
    }

    public Value value() {
        return value;
    }

    public void updateValue(Value value) {
        this.value = Objects.requireNonNull(value);
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }
}
