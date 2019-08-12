package com.dzh.trial.trial.commonStateMachine.core;

import com.dzh.trial.trial.commonStateMachine.exception.StateMachineBizException;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;

public abstract class AbstractGuard<S, E> implements Guard<S, E> {

    @Override
    public boolean evaluate(StateContext<S, E> context) {
        StateMachineContext stateMachineContext = (StateMachineContext) context.getMessage().getHeaders().get("context");
        try {
            return evaluate(stateMachineContext);
        } catch (Exception e) {
            stateMachineContext.setException(e);
            throw new StateMachineBizException(e);
        }
    }

    abstract public boolean evaluate(StateMachineContext stateMachineContext);

}
