package com.example.hospital.dentist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dentist.Dentist;
import com.example.hospital.dentist.commands.CreateDentist;

public class CreateDentistUseCase extends UseCase<RequestCommand<CreateDentist>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateDentist> createDentistRequestCommand) {
        var command = createDentistRequestCommand.getCommand();

        var dentist = new Dentist(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(dentist.getUncommittedChanges()));
    }
}
