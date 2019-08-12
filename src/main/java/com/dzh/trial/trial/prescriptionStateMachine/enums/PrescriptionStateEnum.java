package com.dzh.trial.trial.prescriptionStateMachine.enums;

public enum PrescriptionStateEnum implements BaseEnum {

    WAIT_VALIDATING("0", ""),
    VALIDATING("-1", ""),
    VALIDATED("1", ""),
    VALIDATE_FAILED("11", ""),
    USED("2", "");

    private String code;
    private String desc;

    PrescriptionStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
