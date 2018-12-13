package com.dzh.trial.trial.tryDesignPatterns.entity;

public class ForProxyImpl implements ForProxyInterface {
    @Override
    public void printName() {
        System.out.println("name is dzh");
    }

    @Override
    public void printAge() {
        System.out.println("age is 24");
    }
}
