package com.dzh.trial.trial.commonStateMachine.core;

public interface StateMachineLock {

    boolean lockById(String lockId, long expireTime);

    void releaseLock();

}
