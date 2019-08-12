package com.dzh.trial.trial.prescriptionStateMachine.enums;

import com.dzh.trial.trial.commonStateMachine.core.StateMachineInfo;

public enum StateMachineEnum implements StateMachineInfo {
    PRESCRIPTION("prescriptionStateMachineFactory", "prescriptionStateMachine");

    private String factoryId;
    private String machineId;

    StateMachineEnum(String factoryId, String machineId) {
        this.factoryId = factoryId;
        this.machineId = machineId;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public String getMachineId() {
        return machineId;
    }

    @Override
    public String getStateMachineFactoryBeanName() {
        return this.factoryId;
    }

    @Override
    public String getStateMachineId() {
        return this.machineId;
    }
}
