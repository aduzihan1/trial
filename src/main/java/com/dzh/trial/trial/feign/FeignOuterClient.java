package com.dzh.trial.trial.feign;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FeignOuterClient {

    @PostMapping(value = "/inforcallback.ashx", consumes = MediaType.APPLICATION_JSON_VALUE)
    String pushPrescription(@RequestBody PushPrescriptionRequest request);

}
