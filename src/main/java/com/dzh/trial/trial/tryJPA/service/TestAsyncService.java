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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TestAsyncService {
    private final Logger logger = LoggerFactory.getLogger(TestAsyncService.class);

    private static ExecutorService es = Executors.newFixedThreadPool(8);

    private static AtomicBoolean isAllJobsDone = new AtomicBoolean();

    @Autowired
    private UserRepository ur;

    public void execute(){
        List<Callable<Object>> callableList;
        int pageIndex = 1;
        isAllJobsDone.set(false);
        while (!isAllJobsDone.get()) {
            callableList = new ArrayList<>();
            int maxPageIndex = pageIndex + 10;
            for(;pageIndex <= maxPageIndex;pageIndex++){
                final int curPageIndex = pageIndex;
                callableList.add(new Callable(){
                   public Object call(){
                       return saveUsers(curPageIndex);
                   }
                });
            }

            try {
                es.invokeAll(callableList);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
        logger.info("saveUsers done");

    }

    private Object saveUsers(int pageIndex){
        logger.info("curPageIndex = {}, curThreadName = {}", pageIndex, Thread.currentThread().getName());
        Pageable pageable = new PageRequest(pageIndex, 10);
        List<User> userList = ur.findAll(pageable).getContent();
        if(!CollectionUtils.isEmpty(userList)){
            userList.stream().forEach(t -> {
                System.out.println(t.toString());
            });
        }else {
            isAllJobsDone.set(true);
        }
        logger.info("curPageIndex = {}, curThreadName = {}, end", pageIndex, Thread.currentThread().getName());
        return null;
    }

}
