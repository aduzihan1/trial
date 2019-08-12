package com.dzh.trial.trial.tryIOC.impl;

import com.dzh.trial.trial.tryIOC.Example;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExampleImpl implements Example, BeanFactoryPostProcessor {

    @Override
    public void print() {
        System.out.println("Example print sth");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Example example = (Example) context.getBean(Example.class);
        example.print();
        context.refresh();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("---------------------------------------");
    }
}
