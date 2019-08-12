package com.dzh.trial.trial.commonStateMachine.core;

import com.dzh.trial.trial.commonStateMachine.BeanUtil;
import com.dzh.trial.trial.commonStateMachine.exception.CommonStateMachineException;
import com.dzh.trial.trial.commonStateMachine.exception.StateMachineBizException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService<S, E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateMachineService.class);

    @Autowired
    private BeanUtil beanUtil;

    public boolean changeStateWithLock(StateMachineContext<S, E> stateMachineContext, StateMachineLock lock) {
        StateMachineInfo stateMachineInfo = stateMachineContext.getStateMachineEnum();
        lock.lockById("ncd" + stateMachineInfo.getStateMachineId() + stateMachineContext.getId(), 10000);
        try {
            return changeState(stateMachineContext);
        } finally {
            lock.releaseLock();
        }
    }

    public boolean changeState(StateMachineContext<S, E> stateMachineContext) {
        if (!validate(stateMachineContext)) {
            throw new CommonStateMachineException("illegal context");
        }
        StateMachineInfo stateMachineInfo = stateMachineContext.getStateMachineEnum();
        S source = stateMachineContext.getSource();
        E event = stateMachineContext.getEvent();
        String factoryBeanName = stateMachineInfo.getStateMachineFactoryBeanName();
        String machineId = stateMachineInfo.getStateMachineId();

        try {
            StateMachineFactory stateMachineFactory = beanUtil.getBean(factoryBeanName, StateMachineFactory.class);
            StateMachine stateMachine = stateMachineFactory.getStateMachine(machineId);
            stateMachine.getStateMachineAccessor().withRegion().resetStateMachine(new DefaultStateMachineContext
                            (source, null, null, null, null, machineId));
            Message message = MessageBuilder
                    .withPayload(event)
                    .setHeader("curId", stateMachineContext.getId())
                    .setHeader("context", stateMachineContext)
                    .build();
            stateMachine.start();
            stateMachine.sendEvent(message);
            if (stateMachineContext.getException() != null)
                throw stateMachineContext.getException();
        } catch (StateMachineBizException e) {
            LOGGER.error("stateMachine biz error occurs, message is {}", e.getMessage(), e);
        } catch (Throwable e) {
            LOGGER.error("stateMachine internal error occurs, message is {}", e.getMessage(), e);
        }
        return false;
    }

    private boolean validate(StateMachineContext<S, E> stateMachineContext) {
        String id = stateMachineContext.getId();
        StateMachineInfo stateMachineInfo = stateMachineContext.getStateMachineEnum();
        S source = stateMachineContext.getSource();
        return StringUtils.isNotBlank(id) && stateMachineInfo != null && source != null;
    }

}
