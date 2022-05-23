package com.example.hospital.dietician;

import co.com.sofka.domain.generic.EventChange;
import com.example.hospital.dietician.events.*;

import java.util.HashSet;

public class DieticianChange extends EventChange {
    DieticianChange(Dietician dietician) {
        apply((DieticianCreated event) -> {
            dietician.name = event.getName();
            dietician.clientSet = new HashSet<>();
        });

        apply((ClientAdded event) -> {
            Client client = new Client(event.getClientID(), event.getName(), event.getCondition(), event.getPhoneNumber());
            dietician.clientSet.add(client);
        });

        apply((ClientRemoved event) -> {
            dietician.clientSet.removeIf(client -> client.identity().equals(event.getClientID()));
        });

        apply((ClientConditionUpdated event) -> {
            Client client = dietician.findClientById(event.getClientID()).orElseThrow();
            client.updateFitnessLevel(event.getCondition());
        });

        apply((ClientPhoneNumberUpdated event) -> {
            Client client = dietician.findClientById(event.getClientID()).orElseThrow();
            client.updatePhoneNumber(event.getPhoneNumber());
        });

        apply((ClientNameUpdated event) -> {
            Client client = dietician.findClientById(event.getClientID()).orElseThrow();
            client.updateName(event.getName());
        });

        apply((DietPlanAdded event) -> {
            dietician.dietPlan = new DietPlan(event.getRoutineID(), event.getDescription(), event.getType());
        });

        apply((DietPlanDescriptionUpdated event) -> {
            dietician.dietPlan.updateDescription(event.getDescription());
        });

        apply((DietPlanStateUpdated event) -> {
            dietician.dietPlan.updateIsCompleted(event.getState());
        });

        apply((DietPlanTypeUpdated event) -> {
            dietician.dietPlan.updateType(event.getType());
        });
    }
}
