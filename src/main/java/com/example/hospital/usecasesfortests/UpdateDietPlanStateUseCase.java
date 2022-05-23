package com.example.hospital.usecasesfortests;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.example.hospital.dietician.Dietician;
import com.example.hospital.dietician.commands.UpdateDietPlanState;

public class UpdateDietPlanStateUseCase extends UseCase<RequestCommand<UpdateDietPlanState>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietPlanState> updateRoutineIsCompletedRequestCommand) {
        var command = updateRoutineIsCompletedRequestCommand.getCommand();
        Dietician dietician = Dietician.from(command.getDieticianID(), repository().getEventsBy(command.getDieticianID().value()));
        dietician.updateRoutineIsCompleted(command.getState());
        emit().onResponse(new ResponseEvents(dietician.getUncommittedChanges()));
    }
}
