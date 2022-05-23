package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dentist.commands.CreateDentist;
import com.example.hospital.dentist.events.DentistCreated;
import com.example.hospital.dentist.usecases.CreateDentistUseCase;
import com.example.hospital.dentist.values.DentistID;
import com.example.hospital.dietician.values.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateDentistTest {

    private CreateDentistUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateDentistUseCase();
    }

    @Test
    public void createDentist() {

        DentistID dentistID = DentistID.of("noDentistID");

        Name name = new Name("Juan");

        var command = new CreateDentist(dentistID, name);

        //Events
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        DentistCreated dentistCreated = (DentistCreated) domainEvents.get(0);

        assertEquals("Juan", dentistCreated.getName().value());
        assertEquals("noDentistID", dentistCreated.aggregateRootId());

    }
}