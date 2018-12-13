package com.dzh.trial.trial.tryDesignPatterns.decorator.myExample;

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

    public static void main(String[] args) {
        OriginalInterface ori = new OriginalImpl();
        ori.method();
        System.out.println("start decorating");
        DecoratorA decoratorA = new DecoratorA(ori);
        decoratorA.method();
        decoratorA.methodA();
        DecoratorB decoratorB = new DecoratorB(decoratorA);
        decoratorB.method();
        decoratorB.methodB();
    }
}
