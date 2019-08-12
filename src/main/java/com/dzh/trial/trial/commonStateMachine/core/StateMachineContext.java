package com.dzh.trial.trial.commonStateMachine.core;

public class StateMachineContext<S, E> {

    private String id;
    private StateMachineInfo stateMachineEnum;
    private Object params;
    private S source;
    private E event;
    private Throwable exception;

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }

    public S getSource() {
        return source;
    }

    public void setSource(S source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StateMachineInfo getStateMachineEnum() {
        return stateMachineEnum;
    }

    public void setStateMachineEnum(StateMachineInfo stateMachineEnum) {
        this.stateMachineEnum = stateMachineEnum;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public boolean hasException() {
        return getException() != null;
    }

    @Override
    public String toString() {
        return "StateMachineContext{" +
                "id='" + id + '\'' +
                ", stateMachineEnum=" + stateMachineEnum +
                ", params=" + params +
                ", source=" + source +
                ", event=" + event +
                ", exception=" + exception +
                '}';
    }
}
