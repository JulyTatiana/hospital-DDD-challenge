package com.example.hospital.alltests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateDietPlanState;

public class UpdateDietPlanIsCompletedUseCase extends UseCase<RequestCommand<UpdateDietPlanState>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietPlanState> updateRoutineIsCompletedRequestCommand) {
        var command = updateRoutineIsCompletedRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getTrainerID(), repository().getEventsBy(command.getTrainerID().value()));
        dietician.updateRoutineIsCompleted(command.getIsCompleted());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
