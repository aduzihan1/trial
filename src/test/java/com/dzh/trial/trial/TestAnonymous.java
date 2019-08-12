package com.dzh.trial.trial;

import com.dzh.trial.trial.commonStateMachine.BeanUtil;
import com.dzh.trial.trial.prescriptionStateMachine.config.TestAnonymousInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.guard.Guard;

import java.lang.reflect.Field;

public class TestAnonymous {

    public int i;

    @Autowired
    private BeanUtil beanUtil;

    @Test
    public void testing() {
        TestAnonymousInterface testAnonymous = beanUtil.getBean("testAnonymous", TestAnonymousInterface.class);
        testAnonymous.execute();
        System.out.println("executed");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestAnonymous testAnonymous = new TestAnonymous();
        try {
            Field field = testAnonymous.getClass().getDeclaredField("i");
            field.set(testAnonymous, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
