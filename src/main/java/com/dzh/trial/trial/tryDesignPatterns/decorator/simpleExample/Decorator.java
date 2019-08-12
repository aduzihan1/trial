package com.dzh.trial.trial.tryDesignPatterns.decorator.simpleExample;

public class Decorator implements OriginalInterface {
    protected OriginalInterface ori;

    public Decorator(OriginalInterface ori){
        super();
        this.ori = ori;
    }


    @Override
    public void method() {
        ori.method();
    }
}
