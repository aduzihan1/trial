package com.dzh.trial.trial.tryDesignPatterns.proxy;

import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyImpl;
import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyInterface;
import com.dzh.trial.trial.tryDesignPatterns.entity.ForProxyNotImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//使用继承的方式加强方法
//spring能过bean容器的getBean来实现aop的自动代理，返回最终的代理类
//在jdk7以后，jdk的动态代理性能比cglib高很多
public class DynamicProxyCGLIB implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("printName".equals(method.getName())){
            return methodProxy.invokeSuper(o, objects);
        }
        System.out.println("before:" + method.getName());
        Object res = methodProxy.invokeSuper(o, objects);
        System.out.println("after" + method.getName());
        return res;
    }

    public Object getProxy(Object target){
        Enhancer var1 = new Enhancer();
        var1.setSuperclass(target.getClass());
        var1.setCallback(this);
        return var1.create();
    }

    public static void main(String[] args) {
        DynamicProxyCGLIB var3 = new DynamicProxyCGLIB();
        ForProxyNotImpl var1 = new ForProxyNotImpl();
        ForProxyNotImpl var2 = (ForProxyNotImpl)var3.getProxy(var1);
        var2.printName();
        var2.printAge();
    }


}
