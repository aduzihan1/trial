package com.dzh.trial.trial.trySpringRetry;

public class RetryableException extends RuntimeException {

    private RetryableContext context;

    public RetryableException(RetryableContext context) {
        super();
        this.context = context;
    }

    public RetryableContext getContext() {
        return context;
    }

}
