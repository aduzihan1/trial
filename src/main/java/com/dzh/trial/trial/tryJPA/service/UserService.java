package com.dzh.trial.trial.tryJPA.service;

import com.dzh.trial.trial.tryJPA.entity.User;
import com.dzh.trial.trial.tryJPA.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static AtomicBoolean isDataAllCopied = new AtomicBoolean();

    @Autowired
    UserRepository ur;

    @Autowired
    TestAsyncService tas;

    @Transactional
    public String testHibernateSave(){
        User user = new User();
        user.setId("100000000000");
        user.setAge(10);
        user.setUname("1234");
        ur.save(user);
        ur.flush();
        System.out.println("123");
        return "123";
    }

    public void testAsync(){
        isDataAllCopied.set(false);
        int pageIndex = 0;
        while(!isDataAllCopied.get()){
            //tas.saveUsers(pageIndex++);
        }
        logger.info("finalPageIndex = {}", pageIndex);
    }

    private static void Combine(char[] a, int num, String b, int low, int high) {
        if (num == 0) {
            System.out.print(b+" ");;
        }else {
            for (int i = low; i < a.length; i++) {
                b += a[i];
                Combine(a, num - 1, b, i + 1, a.length);
                b = b.substring(0, b.length() - 1);
            }
        }
    }

    private static void Combine(char[] a, int num){
        Combine(a, num, new String(), 0, a.length);
    }

    public static void main(String[] args){
        char[] a ={'a','b','c','d','e','f','g','h'};
        Combine(a,3);
    }


}
