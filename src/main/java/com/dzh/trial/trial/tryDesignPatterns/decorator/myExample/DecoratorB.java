package com.dzh.trial.trial.tryDesignPatterns.decorator.myExample;

public class DecoratorB extends Decorator {
    public DecoratorB(OriginalInterface ori){
        super(ori);
    }

    public void methodB(){
        System.out.println("decorator B offering other method");
    }

    public void method(){
        System.out.println("decorator B advise method start");
        ori.method();
        System.out.println("decorator B advise method end");
    }

    public static void main(String[] args) {
        OriginalInterface ori = new OriginalImpl();
        ori.method();
        System.out.println("start decorating");
        DecoratorB decoratorB = new DecoratorB(ori);
        decoratorB.method();
        decoratorB.methodB();
    }
}
