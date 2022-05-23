package com.example.hospital.optometry;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.optometry.events.*;
import com.example.hospital.optometry.values.*;
import com.example.hospital.dietician.values.Name;

import java.util.List;
import java.util.Set;

public class Optometry extends AggregateEvent<OptometryID> {
    protected Set<Product> productSet;
    protected Set<Service> serviceSet;
    protected Name name;
    public Optometry(OptometryID entityId, Name name) {
        super(entityId);
        appendChange(new OptometryCreated(name)).apply();

    }
    private Optometry(OptometryID entityId) {
        super(entityId);
        subscribe(new OptometryChange(this));
    }

    public static Optometry from(OptometryID optometryID, List<DomainEvent> domainEvents) {
        Optometry frontDesk = new Optometry(optometryID);
        domainEvents.forEach(frontDesk::applyEvent);
        return frontDesk;
    }

}
