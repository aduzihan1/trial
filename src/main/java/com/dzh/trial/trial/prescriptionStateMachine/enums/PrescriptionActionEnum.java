package com.dzh.trial.trial.prescriptionStateMachine.enums;

public enum PrescriptionActionEnum implements BaseActionEnum {

    VALIDATE_SUCCESS("prescriptionValidationEventAction", "")
    , VALIDATE_FAIL("prescriptionValidationEventAction", "")
    , USE("prescriptionValidationEventAction", "");

    private String code;
    private String desc;

    PrescriptionActionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getBeanName() {
        return this.code;
    }

}
