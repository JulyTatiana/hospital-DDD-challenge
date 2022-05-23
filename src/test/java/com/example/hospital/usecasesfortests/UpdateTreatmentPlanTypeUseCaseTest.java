package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.hospital.dietician.commands.UpdateDietPlanType;
import com.example.hospital.dietician.events.ClientAdded;
import com.example.hospital.dietician.events.DietPlanAdded;
import com.example.hospital.dietician.events.DietPlanTypeUpdated;
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

class UpdateTreatmentPlanTypeUseCaseTest {

    @InjectMocks
    private UpdateDietPlanTypeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateDietPlanDescription() {
        DieticianID fakeDieticianID = DieticianID.of("noDieticianID");
        Type type = new Type(TypeEnum.FLEXIBILITY);
        var command = new UpdateDietPlanType(fakeDieticianID, type);

        Mockito.when(repository.getEventsBy("noDieticianID")).thenReturn(List.of(
                new DieticianCreated(new Name("Emilia")),
                new DietPlanAdded(com.example.hospital.dietician.values.DietPlanID.of("noRoutine"), new Description("oldDescription"), new Type(TypeEnum.RESISTANCE)),
                new ClientAdded(ClientID.of("noClientID"), new Name("david"), new Condition(ConditionEnum.MEDIUM), new PhoneNumber("3105968248")),
                new ClientAdded(ClientID.of("anotherClient"), new Name("Luis"), new Condition(ConditionEnum.MEDIUM), new PhoneNumber("3110001212"))
        ));

        useCase.addRepository(repository);

        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .setIdentifyExecutor("noDieticianID")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DietPlanTypeUpdated) domainEvents.get(0);
        Assertions.assertEquals(TypeEnum.FLEXIBILITY, event.getType().value());
        Mockito.verify(repository).getEventsBy("noDieticianID");
    }
}