package com.dzh.trial.trial.prescriptionStateMachine.config;

import com.dzh.trial.trial.prescriptionStateMachine.action.PrescriptionEventHandler;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionActionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Component
@WithStateMachine(id = PrescriptionStateMachineConfig.STATE_MACHINE_ID)
public class PrescriptionEventConfigure {

    @Autowired
    private PrescriptionEventHandler prescriptionEventHandler;

    @OnStateChanged(source = "WAIT_VALIDATING", target = "VALIDATED")
    public void validatePrescriptionSuccess(Message<PrescriptionActionEnum> message) {
        prescriptionEventHandler.execute(PrescriptionActionEnum.VALIDATE_SUCCESS, message);
    }

    @OnStateChanged(source = "WAIT_VALIDATING", target = "VALIDATE_FAILED")
    public void validatePrescriptionFail(Message<PrescriptionActionEnum> message) {
        System.out.println("------fail");
        prescriptionEventHandler.execute(PrescriptionActionEnum.VALIDATE_FAIL, message);
    }

}
