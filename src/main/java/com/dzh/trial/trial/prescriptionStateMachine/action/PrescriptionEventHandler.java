package com.dzh.trial.trial.prescriptionStateMachine.action;

import com.dzh.trial.trial.commonStateMachine.core.AbstractStateMachineEventHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionEventHandler extends AbstractStateMachineEventHandler {

    @Override
    public boolean validate(Message message) {
        System.out.println("event handler validating");
        return true;
    }

}
