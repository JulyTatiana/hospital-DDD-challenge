package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateClientPhoneNumber;

public class UpdateClientPhoneNumberUseCase extends UseCase<RequestCommand<UpdateClientPhoneNumber>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClientPhoneNumber> updateClientPhoneNumberRequestCommand) {
        var command = updateClientPhoneNumberRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));

        dietician.updateClientPhoneNumber(command.getClientID(), command.getPhoneNumber());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
