package com.dzh.trial.trial.tryDesignPatterns.decorator.simpleExample;

public class OriginalImpl implements OriginalInterface{

    @Override
    public void method() {
        System.out.println("i am the class to be decorated");
    }

    public static void main(String[] args) {
        OriginalInterface originalInterface = new OriginalImpl();
        System.out.println("---------------");
        originalInterface.method();
        System.out.println("---------------");
        DecoratorA decoratorA = new DecoratorA(originalInterface);
        System.out.println("---------------");
        decoratorA.method();
        decoratorA.methodA();
        System.out.println("---------------");
        DecoratorB decoratorB = new DecoratorB(originalInterface);
        decoratorB.method();
        decoratorB.methodB();
        System.out.println("---------------");
    }

}
