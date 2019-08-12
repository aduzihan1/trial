package com.dzh.trial.trial.tryDesignPatterns.decorator.simpleExample;

public class DecoratorA extends Decorator {
    public DecoratorA(OriginalInterface ori){
        super(ori);
    }

    public void methodA(){
        System.out.println("decorator A offering other method");
    }

    public void method(){
        System.out.println("decorator A advise method start");
        ori.method();
        System.out.println("decorator A advise method end");
    }

}
