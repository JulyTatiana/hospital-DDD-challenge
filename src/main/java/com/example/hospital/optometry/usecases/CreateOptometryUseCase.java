package com.example.hospital.optometry.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.optometry.Optometry;
import com.example.hospital.optometry.commands.CreateOptometry;

public class CreateOptometryUseCase extends UseCase<RequestCommand<CreateOptometry>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateOptometry> createFrontDeskRequestCommand) {
        var command = createFrontDeskRequestCommand.getCommand();
        var frontDesk = new Optometry(command.getEntityId(), command.getName());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}