package com.dzh.trial.trial.trySpringRetry;

public class RetryableContext {

    private String code;
    private Object params;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RetryableContext{" +
                "code='" + code + '\'' +
                ", params=" + params +
                '}';
    }
}
