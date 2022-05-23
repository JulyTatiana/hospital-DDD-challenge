package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateDietPlanDescription;

public class UpdateDietPlanDescriptionUseCase extends UseCase<RequestCommand<UpdateDietPlanDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietPlanDescription> updateRoutineDescriptionRequestCommand) {
        var command = updateRoutineDescriptionRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        dietician.updateRoutineDescription(command.getDescription());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
