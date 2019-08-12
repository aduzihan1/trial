package com.dzh.trial.trial.tryJPA.controller;

import com.dzh.trial.trial.config.BeanPostProxy;
import com.dzh.trial.trial.prescriptionStateMachine.entity.Prescription;
import com.dzh.trial.trial.tryAnnotation.UseCase;
import com.dzh.trial.trial.tryJPA.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@RequestMapping("/try")
@RestController
public class TrialController {
    private static final Logger logger = LoggerFactory.getLogger(TrialController.class);

    @GetMapping("/getMsg")
    public String getMsg(HttpServletResponse response, @Valid @RequestBody Prescription prescription,
                         TestEnum testEnum){
        logger.info(testEnum.getCode());
        UserService us = (UserService)BeanPostProxy.USER_SERVICE_MAP.get(123);
        UseCase useCase = us.getClass().getAnnotation(UseCase.class);
        System.out.println(123);
        if (useCase != null)
            logger.info(useCase.id() + useCase.description());
        return "213";
    }

    public static void main(String[] args) {

    }

    enum TestEnum {

        TESTING("123");

        TestEnum(String code) {
            this.code = code;
        }

        private String code;

        public String getCode() {
            return code;
        }
    }

}
