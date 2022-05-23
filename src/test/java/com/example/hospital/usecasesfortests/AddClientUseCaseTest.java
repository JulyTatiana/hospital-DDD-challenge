package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.AddClient;
import com.example.hospital.dietician.events.ClientAdded;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {

    @InjectMocks
    private AddClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addClientToDietician() {

        DieticianID dieticianID = DieticianID.of("noDieticianID");
        Name name = new Name("Salomon");
        Condition condition = new Condition(ConditionEnum.HIGH);
        PhoneNumber phoneNumber = new PhoneNumber("3105968248");
        var command = new AddClient(dieticianID, name, condition, phoneNumber);

        when(repository.getEventsBy("noDieticianID")).thenReturn(history());
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTrainerID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientAdded) events.get(0);
        Assertions.assertEquals("Salomon", event.getName().value());
        assertEquals("3105968248", event.getPhoneNumber().value());
        assertEquals(ConditionEnum.HIGH, event.getFitnessLevel().value());
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