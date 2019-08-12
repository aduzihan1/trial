package com.dzh.trial.trial.prescriptionStateMachine.config;

import com.dzh.trial.trial.commonStateMachine.core.AbstractGuard;
import com.dzh.trial.trial.commonStateMachine.core.StateMachineContext;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionActionEnum;
import com.dzh.trial.trial.prescriptionStateMachine.enums.PrescriptionStateEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory(name = "prescriptionStateMachineFactory")
public class PrescriptionStateMachineConfig extends EnumStateMachineConfigurerAdapter<PrescriptionStateEnum, PrescriptionActionEnum> {

    public static final String STATE_MACHINE_ID = "prescriptionStateMachine";

    @Override
    public void configure(StateMachineConfigurationConfigurer<PrescriptionStateEnum, PrescriptionActionEnum> config) throws Exception {
        config.withConfiguration().machineId(STATE_MACHINE_ID);
    }

    @Override
    public void configure(StateMachineStateConfigurer<PrescriptionStateEnum, PrescriptionActionEnum> states) throws Exception {
        states.withStates()
                .initial(PrescriptionStateEnum.WAIT_VALIDATING)
                .choice(PrescriptionStateEnum.VALIDATING)
                .states(EnumSet.allOf(PrescriptionStateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<PrescriptionStateEnum, PrescriptionActionEnum> transitions) throws Exception {
        transitions
                /*.withExternal()
                .source(PrescriptionStateEnum.WAIT_VALIDATING)
                .target(PrescriptionStateEnum.VALIDATED)
                .event(PrescriptionActionEnum.VALIDATE_SUCCESS)
                .and()*/

                .withExternal()
                .source(PrescriptionStateEnum.WAIT_VALIDATING)
                .target(PrescriptionStateEnum.VALIDATING)
                .event(PrescriptionActionEnum.VALIDATE_SUCCESS)
                .and()
                .withChoice()
                .source(PrescriptionStateEnum.VALIDATING)
                .first(PrescriptionStateEnum.VALIDATED, validatingGuard())
                .last(PrescriptionStateEnum.VALIDATE_FAILED);
    }



    @Bean
    public Guard<PrescriptionStateEnum, PrescriptionActionEnum> validatingGuard() {
        return new AbstractGuard<PrescriptionStateEnum, PrescriptionActionEnum>() {
            @Override
            public boolean evaluate(StateMachineContext stateMachineContext) {
                System.out.println("source" + stateMachineContext.getSource());
                return true;
            }
        };
    }

    @Bean
    public TestAnonymousInterface testAnonymous() {
        return new TestAnonymousInterface() {
            @Override
            @Async
            public void execute() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("123123123123123");
            }
        };
    }

}
