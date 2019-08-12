package com.dzh.trial.trial.commonStateMachine.core;

import com.dzh.trial.trial.prescriptionStateMachine.enums.BaseActionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import java.util.Map;

public abstract class AbstractStateMachineEventHandler {

    @Autowired
    protected Map<String, StateMachineAction> eventActionMap;

    public abstract boolean validate(Message message);

    public void execute(BaseActionEnum baseActionEnum, Message message) {
        StateMachineContext stateMachineContext = (StateMachineContext) message.getHeaders().get("context");
        try {
            if (validate(message)) {
                StateMachineAction eventAction = eventActionMap.get(baseActionEnum.getBeanName());
                eventAction.execute(message);
            }
        } catch (Exception e) {
            stateMachineContext.setException(e);
        }
    }

}
