package com.dzh.trial.trial;

import com.dzh.trial.trial.trySpringRetry.RetryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestRetryable extends BasicTest {

    @Autowired
    RetryService retryService;

    @Test
    public void testing() {
        retryService.retryTask2();
        System.out.println("test thread end");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
