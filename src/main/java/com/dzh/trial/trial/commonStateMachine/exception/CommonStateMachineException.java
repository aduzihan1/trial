package com.dzh.trial.trial.commonStateMachine.exception;

public class CommonStateMachineException extends RuntimeException {

    public CommonStateMachineException(String message) {
        super(message);
    }

    public CommonStateMachineException(Throwable e) {
        super(e);
    }

}
