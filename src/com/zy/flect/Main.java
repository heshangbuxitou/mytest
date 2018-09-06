package com.zy.flect;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Person person = new Student("zhangsan");
        InvocationHandler personHandler = new MyInvocationHandler(person);
        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), person.getClass().getInterfaces(), personHandler);
        proxyPerson.giveMoney();

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Student.class.getInterfaces());
        String path = "F:/workspace/mytest/src/com/zy/flect/StuProxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
