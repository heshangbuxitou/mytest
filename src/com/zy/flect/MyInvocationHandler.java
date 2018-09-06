package com.zy.flect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    public Person person;

    public MyInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        System.out.println("我被代理了");
        Object result = method.invoke(person, args);
        System.out.println(System.currentTimeMillis());
        return result;

    }
}
