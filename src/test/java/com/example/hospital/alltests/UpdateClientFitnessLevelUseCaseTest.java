package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.UpdateClientFitnessLevel;
import com.example.hospital.dietician.events.ClientAdded;
import com.example.hospital.dietician.events.ClientFitnessLevelUpdated;
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
class UpdateClientFitnessLevelUseCaseTest {

    @InjectMocks
    private UpdateClientFitnessLevelUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClientFitnessLevel() {

        DieticianID fakeDieticianID = DieticianID.of("noDieticianID");
        ClientID fakeClientID = ClientID.of("noClientID");
        FitnessLevel updatedFitnessLevel = new FitnessLevel(FitnessLevelEnum.HIGH);

        var command = new UpdateClientFitnessLevel(fakeDieticianID, fakeClientID, updatedFitnessLevel);

        Mockito.when(repository.getEventsBy("noDieticianID")).thenReturn(List.of(
                new DieticianCreated(new Name("Emilia")),
                new ClientAdded(ClientID.of("noClientID"), new Name("david"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312987657")),
                new ClientAdded(ClientID.of("anotherClient"), new Name("Luis"), new FitnessLevel(FitnessLevelEnum.MEDIUM), new PhoneNumber("312777757"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("noDieticianID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClientFitnessLevelUpdated) domainEvents.get(0);
        Assertions.assertEquals(FitnessLevelEnum.HIGH, event.getFitnessLevel().value());
        Assertions.assertEquals("noClientID", event.getClientID().value());
        Mockito.verify(repository).getEventsBy("noDieticianID");
    }

}