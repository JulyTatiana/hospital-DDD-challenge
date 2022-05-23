package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateDietPlanType;

public class UpdateDietPlanTypeUseCase extends UseCase<RequestCommand<UpdateDietPlanType>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietPlanType> updateRoutineTypeRequestCommand) {
        var command = updateRoutineTypeRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        dietician.updateRoutineType(command.getType());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
