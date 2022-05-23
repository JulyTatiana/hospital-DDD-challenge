package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.RemoveClient;

public class RemoveClientUseCase extends UseCase<RequestCommand<RemoveClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveClient> removeClientRequestCommand) {
        var command = removeClientRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        dietician.removeClient(command.getClientID());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
