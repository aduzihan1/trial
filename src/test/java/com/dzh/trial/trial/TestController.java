package com.dzh.trial.trial;

import com.dzh.trial.trial.feign.FeignOuterClient;
import com.dzh.trial.trial.feign.PushPrescriptionRequest;
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

    @Autowired
    FeignOuterClient client;

    @Test
    public void testing(){
        PushPrescriptionRequest request = new PushPrescriptionRequest();
        request.setFile("123");
        request.setMobileNo("18888888888");
        request.setPrescriptionNo("123123123");
        String res = client.pushPrescription(request);
        System.out.println(res);
    }

    @Test
    public void tryClone(){

    }

}
