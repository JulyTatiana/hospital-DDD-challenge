package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.commands.CreateDietician;
import com.example.hospital.dietician.Dietician;

public class CreateDieticianUseCase extends UseCase<RequestCommand<CreateDietician>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateDietician> createTrainerRequestCommand) {
        var command = createTrainerRequestCommand.getCommand();

        var trainer = new Dietician(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(trainer.getUncommittedChanges()));
    }
}
