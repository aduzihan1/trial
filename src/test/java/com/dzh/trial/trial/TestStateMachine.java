package com.dzh.trial.trial;

import com.dzh.trial.trial.commonStateMachine.core.StateMachineContext;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionActionEnum;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionStateEnum;
import com.dzh.trial.trial.prescriptionStateMachine.enums.StateMachineEnum;
import com.dzh.trial.trial.commonStateMachine.core.StateMachineService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestStateMachine extends BasicTest {

    @Autowired
    private StateMachineService stateMachineService;

    @Test
    public void testState() {
        StateMachineContext<PrescriptionStateEnum, PrescriptionActionEnum> stateMachineContext = new StateMachineContext<>();
        stateMachineContext.setId("123");
        stateMachineContext.setStateMachineEnum(StateMachineEnum.PRESCRIPTION);
        stateMachineContext.setEvent(PrescriptionActionEnum.VALIDATE_SUCCESS);
        stateMachineContext.setSource(PrescriptionStateEnum.WAIT_VALIDATING);
        System.out.println("stateResult-------" + stateMachineService.changeState(stateMachineContext));
    }

}
