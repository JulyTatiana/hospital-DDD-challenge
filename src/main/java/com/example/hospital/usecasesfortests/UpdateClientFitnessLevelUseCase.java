package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateClientFitnessLevel;

public class UpdateClientFitnessLevelUseCase extends UseCase<RequestCommand<UpdateClientFitnessLevel>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientFitnessLevel> updateClientFitnessLevelRequestCommand) {
        var command = updateClientFitnessLevelRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        dietician.updateClientFitnessLevel(command.getClientID(), command.getFitnessLevel());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));

    }
}
