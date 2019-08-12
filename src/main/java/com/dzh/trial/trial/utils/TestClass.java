package com.dzh.trial.trial.utils;

import org.apache.poi.util.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestClass {
/**
 * 230302196903060901         17388880052
 * 15193989261
 * 150102199003276515      17388880047
 * 110101199003078830      19199999995
 * 150105199004122947      17388880051
 *
 * 150102199003253938      17366660002
 *
 *
 * C4B0D17D8BE6473C992BF3DF4B569EEE
 * */

    public static void main(String[] args) throws Exception {

        /*String algorithm = "HmacSHA256";
        String requestSecret = "b69dc8f1b146f877";
        String requestUUID = "1";
        long timestamp = new Date().getTime();
        Mac hmacSha256 = Mac.getInstance(algorithm);
        byte[] keyBytes = requestSecret.getBytes("utf-8");
        String src = timestamp + requestUUID;
        System.out.println(timestamp);
        hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, algorithm));
        String sign = Base64Utils.encodeToString(hmacSha256.doFinal(src.getBytes("utf-8")));
        System.out.println(sign);
        HttpHeaders requestHeader1 = new HttpHeaders();
        requestHeader1.add("X-Rb-key", "10f7ca8f3f016020");
        requestHeader1.add("x-rb-requuid", "1");
        requestHeader1.add("x-rb-timestamp", timestamp+"");
        requestHeader1.add("x-rb-sign", sign);
        Map params1 = new HashMap();
        HttpEntity requestEntity1 = new HttpEntity(params1, requestHeader1);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.pingan.com.cn/open/appsvr/yb/rb-api/ncdmain/api/examination/haoluowei/push/report?access_token=8876ED33D5A946CBB59B545A449BDAB9&request_id=2";
        Object result = restTemplate.postForEntity(url, requestEntity1, Object.class);
        System.out.println(result);*/
        Map<String, Object> params = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        params.put("examinationReportId", "20190428hihih1751");
        params.put("patientName", "17388880055");
        params.put("patientIdCardNo", "150102199003253938");
        params.put("patientTel", "17388880051");
        params.put("examinationType", "ABP");
        params.put("examinationStartTime", "2019-04-18 11:11:11");
        params.put("examinationEndTime", "2019-04-13 11:11:11");
        params.put("doctorName", "士别三日中");
        params.put("doctorTel", "18817874973");
        params.put("doctorIdCardNo", "110101198703081550");
        params.put("doctorInstitutionName", "城中颉颉颉颉叶右颉颉城中颉颉嚅城中颉颉颉颉叶右颉颉城中颉颉嚅城中颉颉颉颉叶右颉颉城中颉颉嚅城中颉颉颉颉叶右颉颉城中颉颉嚅");
        params.put("doctorInstitutionId", "hunan001");
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("/Users/dzh/xuya"));
        params.put("examinationReportPdfFile", bytes);
        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.add("X-Rb-key", "10c9402613007014");
        requestHeader.add("x-rb-requuid", "998cee59-a530-4bc3-ada8-d4935fd3d22f");
        requestHeader.add("x-rb-timestamp", "1555922022443");
        requestHeader.add("x-rb-sign", "BqKCDJtiEUdlkXIXbMyWfPtTWOKKJDU9C4gwTwTHCZ4=");
        HttpEntity requestEntity = new HttpEntity(params, requestHeader);
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity("https://test-api.pingan.com.cn:20443/open/appsvr/yb/rb-api/ncdmain/api/examination/haoluowei/push/report?request_id=1&access_token=7848C0510974448692F81039E493D11A",
                requestEntity, Object.class);
        System.out.println(objectResponseEntity);
    }

}
