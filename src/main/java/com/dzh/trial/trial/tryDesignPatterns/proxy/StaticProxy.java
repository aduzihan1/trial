package com.dzh.trial.trial.tryDesignPatterns.proxy;

//以String为例
public class StaticProxy {
    String str;

    public StaticProxy(String str){
        this.str = str;
    }

    public boolean equals(Object obj){
        System.out.println("before equals");
        boolean resBoolean = str.equals(obj);
        System.out.println("after equals");
        return resBoolean;
    }

    public static void main(String[] args) {
        String str = "abc";
        StaticProxy sp = new StaticProxy(str);
        System.out.println(sp.equals("abc"));
    }
}
