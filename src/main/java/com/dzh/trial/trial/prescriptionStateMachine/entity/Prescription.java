package com.dzh.trial.trial.prescriptionStateMachine.entity;

import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionStateEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class Prescription {

    @Length(max = 10)
    private String id;
    private PrescriptionStateEnum state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PrescriptionStateEnum getState() {
        return state;
    }

    public void setState(PrescriptionStateEnum state) {
        this.state = state;
    }

}
