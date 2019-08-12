package com.dzh.trial.trial.testQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Message implements Delayed {

    private long executeTime;
    private String data;

    public static void main(String[] args) {
        System.out.println(TimeUnit.NANOSECONDS.convert(1000, TimeUnit.MILLISECONDS));
    }

    public Message(int delayTime, String data) {
        this.executeTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.data = data;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.executeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
