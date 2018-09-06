package com.zy.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NiMingTest {
    @Before
    public void start(){
        Logger.getAnonymousLogger().info("start");
    }
    @Test
    public void myTest(){
        Logger.getAnonymousLogger().info("This is the test case");
    }
    public static void main(String[] args) {
    }
}


