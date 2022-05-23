package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.AddDietPlan;

public class AddDietPlanUseCase extends UseCase<RequestCommand<AddDietPlan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDietPlan> addRoutineRequestCommand) {
        var command = addRoutineRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        
        dietician.addRoutine(command.getDescription(), command.getType());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));

    }
}
