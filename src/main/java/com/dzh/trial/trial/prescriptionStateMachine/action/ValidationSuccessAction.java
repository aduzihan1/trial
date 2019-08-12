package com.dzh.trial.trial.prescriptionStateMachine.action;

import com.dzh.trial.trial.commonStateMachine.exception.StateMachineBizException;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionActionEnum;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Component
public class ValidationSuccessAction implements Action<PrescriptionStateEnum, PrescriptionActionEnum> {

    @Override
    public void execute(StateContext<PrescriptionStateEnum, PrescriptionActionEnum> context) {
        System.out.println("validating");
        throw new StateMachineBizException("123");
    }

}
