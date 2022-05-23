package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateClientName;

public class UpdateClientNameUseCase extends UseCase<RequestCommand<UpdateClientName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientName> updateClientNameRequestCommand) {
        var command = updateClientNameRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getDieticianID(), repository().getEventsBy(command.getDieticianID().value()));
        dietician.updateClientName(command.getClientID(), command.getName());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
