package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateClientCondition;

public class UpdateClientConditionUseCase extends UseCase<RequestCommand<UpdateClientCondition>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientCondition> updateClientFitnessLevelRequestCommand) {
        var command = updateClientFitnessLevelRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getDieticianID(), repository().getEventsBy(command.getDieticianID().value()));

        dietician.updateClientCondition(command.getClientID(), command.getCondition());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));

    }
}
