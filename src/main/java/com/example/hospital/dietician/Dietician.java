package com.example.hospital.dietician;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.events.*;
import com.example.hospital.dietician.values.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Dietician extends AggregateEvent<DieticianID> {
    protected Set<Client> clientSet;
    protected DietPlan dietPlan;

    protected Name name;

    public Dietician(DieticianID entityId, Name name) {
        super(entityId);
        appendChange(new DieticianCreated(name)).apply();
    }

    private Dietician(DieticianID entityId) {
        super(entityId);
        subscribe(new DieticianChange(this));
    }

    public static Dietician from(DieticianID dieticianID, List<DomainEvent> domainEvents) {
        Dietician dietician = new Dietician(dieticianID);
        domainEvents.forEach(dietician::applyEvent);
        return dietician;
    }
//  events
    public void addClient(Name name, Condition condition, PhoneNumber phoneNumber) {
        ClientID clientID = new ClientID();
        appendChange(new ClientAdded(clientID, name, condition, phoneNumber)).apply();
    }

    public void removeClient(ClientID clientID) {
        appendChange(new ClientRemoved(clientID)).apply();
    }

    public void updateClientCondition(ClientID clientID, Condition condition) {
        appendChange(new ClientConditionUpdated(clientID, condition)).apply();
    }

    public void updateClientPhoneNumber(ClientID clientID, PhoneNumber phoneNumber) {
        appendChange(new ClientPhoneNumberUpdated(clientID, phoneNumber)).apply();
    }

    public void updateClientName(ClientID clientID, Name name) {
        appendChange(new ClientNameUpdated(clientID, name)).apply();
    }

    public void addRoutine(Description description, Type type) { //change this
        DietPlanID dietPlanID = new DietPlanID();
        appendChange(new DietPlanAdded(dietPlanID, description, type)).apply();
    }

    public void updateRoutineDescription(Description description) {
        appendChange(new DietPlanDescriptionUpdated(description)).apply();
    }

    public void updateRoutineIsCompleted(State state) {
        appendChange(new DietPlanStateUpdated(state)).apply();
    }

    public void updateRoutineType(Type type) {
        appendChange(new DietPlanTypeUpdated(type)).apply();
    }

    //    findById methods
    protected Optional<Client> findClientById(ClientID clientID) {
        return this.clientSet.stream().filter(client -> client.identity().equals(clientID)).findFirst();
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public DietPlan getRoutine() {
        return dietPlan;
    }

    public Name getName() {
        return name;
    }

}
