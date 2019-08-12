package com.dzh.trial.trial.prescriptionStateMachine.action;

import com.dzh.trial.trial.commonStateMachine.core.StateMachineAction;
import com.dzh.trial.trial.commonStateMachine.exception.StateMachineBizException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("prescriptionValidationEventAction")
public class PrescriptionValidationAction implements StateMachineAction {

    @Override
    public void execute(Message message) {

        System.out.println("validating");
        throw new StateMachineBizException("123");
    }

}
