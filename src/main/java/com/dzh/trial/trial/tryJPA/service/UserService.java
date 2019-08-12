package com.dzh.trial.trial.tryJPA.service;

import com.dzh.trial.trial.tryAnnotation.UseCase;
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

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@UseCase(id = 123)
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static AtomicBoolean isDataAllCopied = new AtomicBoolean();

    private static final String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"

    };

    private static SecureRandom random = new SecureRandom();

    @Autowired
    UserRepository ur;

    @Autowired
    TestAsyncService tas;

    @PostConstruct
    public String testHibernateSave(){
        Optional<User> user = ur.findById("2c90d81e69b8d9a80169b8dd9ccf0006");
        logger.info("{}", user);
        return "123";
    }

    private int runMask() {
        for (int i = 0; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                sb.append(chars[random.nextInt(62)]);
            }
            User user = new User();
            user.setUname(sb.toString());
            ur.save(user);
        }
        return 0;
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

    private static boolean compare(String a, String b) {
        return a == b;
    }

    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(secureRandom.nextInt(2));
        }
    }


}
