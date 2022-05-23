package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.AddDietPlan;
import com.example.hospital.dietician.events.DietPlanAdded;
import com.example.hospital.dietician.events.DieticianCreated;
import com.example.hospital.dietician.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddTreatmentPlanUseCaseTest {
    @InjectMocks
    private AddDietPlanUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDietPlanToDietician() {

        DieticianID dieticianID = DieticianID.of("noDieticianID");
        Description description = new Description("dietPlan test case#1");
        Type type = new Type(TypeEnum.CARDIO);
        var command = new AddDietPlan(dieticianID, description, type);

        Mockito.when(repository.getEventsBy("noDieticianID")).thenReturn(history());
        useCase.addRepository(repository);


        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getDieticianID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (DietPlanAdded) domainEvents.get(0);
        Assertions.assertEquals("dietPlan test case#1", event.getDescription().value());
        Assertions.assertEquals(TypeEnum.CARDIO, event.getType().value());
        Mockito.verify(repository).getEventsBy("noDieticianID");
    }

    private List<DomainEvent> history() {
        DieticianID dieticianID = DieticianID.of("noDieticianID");
        Name name = new Name("Juan");
        var event = new DieticianCreated(name);
        event.setAggregateRootId(dieticianID.value());
        return List.of(event);
    }
}