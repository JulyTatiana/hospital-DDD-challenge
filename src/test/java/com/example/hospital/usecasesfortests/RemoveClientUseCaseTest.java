package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.RemoveClient;
import com.example.hospital.dietician.events.ClientAdded;
import com.example.hospital.dietician.events.ClientRemoved;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RemoveClientUseCaseTest {

    @InjectMocks
    private RemoveClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void removeClientFromDietician() {

        DieticianID fakeDieticianID = DieticianID.of("noDieticianID");
        ClientID fakeClientID = ClientID.of("noClientID");

        var command = new RemoveClient(fakeDieticianID, fakeClientID);

        Mockito.when(repository.getEventsBy("noDieticianID")).thenReturn(List.of(
                new DieticianCreated(new Name("Emilia")),
                new ClientAdded(ClientID.of("noClientID"), new Name("david"), new Condition(ConditionEnum.NORMAL), new PhoneNumber("312987657")),
                new ClientAdded(ClientID.of("anotherClient"), new Name("Luis"), new Condition(ConditionEnum.NORMAL), new PhoneNumber("312777757"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("noDieticianID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientRemoved) domainEvents.get(0);
        Assertions.assertEquals("noClientID", event.getClientID().value());
        assertTrue(event.getWasDeleted());
        Mockito.verify(repository).getEventsBy("noDieticianID");
    }

}
