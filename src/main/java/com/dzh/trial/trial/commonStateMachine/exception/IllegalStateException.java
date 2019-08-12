package com.dzh.trial.trial.commonStateMachine.exception;

public class IllegalStateException extends CommonStateMachineException {

    public IllegalStateException(String message) {
        super(message);
    }

    public IllegalStateException(Throwable e) {
        super(e);
    }

}
