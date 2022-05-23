package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.CreateDietician;
import com.example.hospital.dietician.events.DieticianCreated;
import com.example.hospital.dietician.values.Name;
import com.example.hospital.dietician.values.DieticianID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateDieticianUseCaseTest {
    private CreateDieticianUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CreateDieticianUseCase();
    }

    @Test
    public void createDietician() {

        DieticianID dieticianID = DieticianID.of("noDieticianID");
        Name name = new Name("Ana");
        CreateDietician command = new CreateDietician(dieticianID, name);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        DieticianCreated dieticianCreated = (DieticianCreated) domainEvents.get(0);
        assertEquals("noDieticianID", dieticianCreated.aggregateRootId());
        assertEquals("Ana", dieticianCreated.getName().value());

    }

}