package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.UpdateClientPhoneNumber;
import com.example.hospital.dietician.events.ClientAdded;
import com.example.hospital.dietician.events.ClientPhoneNumberUpdated;
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

@ExtendWith(MockitoExtension.class)
class UpdateClientPhoneNumberUseCaseTest {

    @InjectMocks
    private UpdateClientPhoneNumberUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClientPhoneNumber() {
        DieticianID fakeDieticianID = DieticianID.of("noDieticianID");
        ClientID fakeClientID = ClientID.of("noClientID");
        PhoneNumber phoneNumber = new PhoneNumber("3205827484");

        var command = new UpdateClientPhoneNumber(fakeDieticianID, fakeClientID, phoneNumber);

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

        var event = (ClientPhoneNumberUpdated) domainEvents.get(0);
        Assertions.assertEquals("3205827484", event.getPhoneNumber().value());
        Assertions.assertEquals("noClientID", event.getClientID().value());
        Mockito.verify(repository).getEventsBy("noDieticianID");
    }
}