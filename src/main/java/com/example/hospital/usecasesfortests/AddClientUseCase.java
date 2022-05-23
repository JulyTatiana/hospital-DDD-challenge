package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.commands.AddClient;
import com.example.hospital.dietician.Dietician;

public class AddClientUseCase extends UseCase<RequestCommand<AddClient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddClient> addClientRequestCommand) {
        var command = addClientRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        dietician.addClient(command.getName(), command.getFitnessLevel(), command.getPhoneNumber());

        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));

    }
}
