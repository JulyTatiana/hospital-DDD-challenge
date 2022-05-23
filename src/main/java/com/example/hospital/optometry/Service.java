package com.example.hospital.optometry;

import co.com.sofka.domain.generic.Entity;
import com.example.hospital.optometry.values.ServiceID;
import com.example.hospital.optometry.values.Price;
import com.example.hospital.optometry.values.Tier;

import java.util.Objects;

public class Service extends Entity<ServiceID> {
    protected Tier tier;
    protected Price price;
    public Service(ServiceID entityId, Tier tier, Price price) {
        super(entityId);
        this.tier = tier;
        this.price = price;
    }

    public Tier tier() {
        return tier;
    }

    public void updateTier(Tier tier) {
        this.tier = Objects.requireNonNull(tier);
    }

    public Price price() {
        return price;
    }

    public void updatePrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }
}
