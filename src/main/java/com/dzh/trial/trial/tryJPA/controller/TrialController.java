package com.dzh.trial.trial.tryJPA.controller;

import com.dzh.trial.trial.tryJPA.entity.User;
import com.dzh.trial.trial.tryJPA.repository.UserRepository;
import com.dzh.trial.trial.tryJPA.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class TrialController {
    Logger logger = LoggerFactory.getLogger(TrialController.class);

    @Autowired
    UserService us;

    @GetMapping("/getMsg")
    public String getMsg(){
        us.testHibernateSave();
        return "123";
    }
}
