package com.dzh.trial.trial.trySpringRetry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryService.class);

    private int count = 0;

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 2))
    public void retryTask() {
        LOGGER.info("executed " + count + "times");
        count++;
        throw new RuntimeException();
    }

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
    @Async
    public void retryTask2() {
        LOGGER.info("v2 executed " + count + "times");
        count++;
        RetryableContext context = new RetryableContext();
        context.setCode("10000");
        context.setParams("dingdingding mf");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = "";
        try {
            str = objectMapper.writeValueAsString(context);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new RetryableException(context);
    }

    @Recover
    public void recover(RetryableException e) {
        RetryableContext context = e.getContext();
        LOGGER.info("callback of retryableTask, context is ", e);
    }

}
