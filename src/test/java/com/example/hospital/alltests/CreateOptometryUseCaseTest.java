package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.optometry.commands.CreateOptometry;
import com.example.hospital.optometry.events.OptometryCreated;
import com.example.hospital.optometry.usecases.CreateOptometryUseCase;
import com.example.hospital.optometry.values.OptometryID;
import com.example.hospital.dietician.values.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateOptometryUseCaseTest {

    private CreateOptometryUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CreateOptometryUseCase();
    }

    @Test
    void createOptometry() {
//        given
//        OptometryID of
        OptometryID optometryID = OptometryID.of("noOptometryID");
//        Name
        Name name = new Name("Luz");
//        CreateOptometry command
        var command = new CreateOptometry(optometryID, name);
//        when
//        list of events
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
//        CreateOptometry created
        OptometryCreated optometryCreated = (OptometryCreated) domainEvents.get(0);
//        assert values
        assertEquals("Luz", optometryCreated.getName().value());
        assertEquals("noOptometryID", optometryCreated.aggregateRootId());
    }
}