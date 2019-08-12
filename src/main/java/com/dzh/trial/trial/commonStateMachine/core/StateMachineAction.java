package com.dzh.trial.trial.commonStateMachine.core;

import org.springframework.messaging.Message;

public interface StateMachineAction<T> {

    void execute(Message<T> message);

}
