package com.dzh.trial.trial.tryDesignPatterns.decorator.myExample;

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
