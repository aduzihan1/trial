package com.dzh.trial.trial.prescriptionStateMachine.guard;

import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionActionEnum;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionValidationGuard implements Guard<PrescriptionStateEnum, PrescriptionActionEnum> {

    @Override
    public boolean evaluate(StateContext<PrescriptionStateEnum, PrescriptionActionEnum> context) {
        System.out.println("validation guard");
        return true;
    }

}
