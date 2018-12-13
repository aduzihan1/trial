package com.dzh.trial.trial.tryDesignPatterns.decorator.myExample;

public class OriginalImpl implements OriginalInterface{

    @Override
    public void method() {
        System.out.println("i am the class to be decorated");
    }
}
