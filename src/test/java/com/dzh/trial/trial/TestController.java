package com.dzh.trial.trial;

import com.dzh.trial.trial.tryJPA.controller.TrialController;
import com.dzh.trial.trial.tryJPA.service.TestAsyncService;
import com.dzh.trial.trial.tryJPA.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestController extends BasicTest {
    @Autowired
    UserService us;

    @Autowired
    TestAsyncService tas;

    @Test
    public void testing(){
        tas.execute();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tryClone(){

    }

}
