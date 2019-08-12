package com.dzh.trial.trial.config;

import com.dzh.trial.trial.tryAnnotation.UseCase;
import com.dzh.trial.trial.tryJPA.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class BeanPostProxy implements BeanPostProcessor {

    private final static Logger logger = LoggerFactory.getLogger(BeanPostProxy.class);
    public static final Map<Integer, Object> USER_SERVICE_MAP = new HashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        UseCase useCase = bean.getClass().getAnnotation(UseCase.class);
        if (useCase != null) {
            logger.error(useCase.id() + useCase.description());
            USER_SERVICE_MAP.put(useCase.id(), bean);
            logger.info("userMap is {}", USER_SERVICE_MAP);
        }
        return bean;
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
    }

}
