package com.zy.test;


import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class LogTest {
    public void test(){
        Logger logger = Logger.getLogger(LogTest.class.getName());
        try {
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            logger.info(String.format("[{%s}] name is null,ignore the method.", "11"),e);
        }
    }

    public Long overDayMillisecond(int overDay){
        long currentMilliseconds = System.currentTimeMillis();
        long overMilliseconds  = overDay * 24 * 60 * 60 * 1000;
        return currentMilliseconds + overMilliseconds;
    }
    public static void main(String[] args) {
        System.out.println(new LogTest().overDayMillisecond(0));
    }
}
