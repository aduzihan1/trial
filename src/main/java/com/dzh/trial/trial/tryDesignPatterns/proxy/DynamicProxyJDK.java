package com.dzh.trial.trial.tryDesignPatterns.proxy;

import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyImpl;
import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyInterface;
import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyNotImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//继承了Proxy类，会实现传入的所有接口方法以此达成代理的效果,即被代理的类必须要实现接口
//将继承InvocationHandler的类理解为代理方式描述类，真正的代理类由newProxyInstance生成
public class DynamicProxyJDK implements InvocationHandler {

    Object source;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method");
        Object res = method.invoke(source, args);
        System.out.println("after method");
        return res;
    }

    public Object getProxy(Object source){
        this.source = source;
        return Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        DynamicProxyJDK jdkProxy = new DynamicProxyJDK();
        ForProxyInterface source = new ForProxyImpl();
        ForProxyInterface proxyInstance = (ForProxyInterface)jdkProxy.getProxy(source);
        proxyInstance.printAge();
        proxyInstance.printName();
    }
}
