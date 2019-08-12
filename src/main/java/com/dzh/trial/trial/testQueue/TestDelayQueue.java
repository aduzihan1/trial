package com.dzh.trial.trial.testQueue;

import java.util.concurrent.*;

public class TestDelayQueue implements Runnable {

    private DelayQueue<Message> delayQueue;

    public DelayQueue<Message> getDelayQueue() {
        return delayQueue;
    }

    public void setDelayQueue(DelayQueue<Message> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("taking");
            try {
                Message message = delayQueue.take();
                System.out.println(message.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        TestDelayQueue testDelayQueue = new TestDelayQueue();
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        testDelayQueue.setDelayQueue(delayQueue);
        executorService.execute(testDelayQueue);


        Message m1 = new Message(5000, "123");
        Message m2 = new Message(5000, "234");
        delayQueue.offer(m1);
        delayQueue.offer(m2);
    }

}
