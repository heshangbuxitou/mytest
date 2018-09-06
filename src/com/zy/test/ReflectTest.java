package com.zy.test;

import com.zy.domain.User;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Locale;

public class ReflectTest {
    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, UnsupportedEncodingException {
        String s = "Hello World";
        System.out.println("s = " + s);
        Field declaredFieldString = String.class.getDeclaredField("value");
        declaredFieldString.setAccessible(true);
        char[] value = (char[]) declaredFieldString.get(s);
        value[5] = '_';
        System.out.println("s = " + s);

        String ss = "你好";
        ss = new String(ss.getBytes("GB2312"), "ISO-8859-1");
        System.out.println(ss);

    }

    @Test
    public void testRefletctConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class[] classes = new Class[]{String.class, String.class};
        Constructor<TwoString> constructor = TwoString.class.getConstructor(classes);
        Object[] objects = new Object[]{"hello", "world"};
        TwoString twoString = constructor.newInstance(objects);
    }

    @Test
    public void testMethod() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String prop = "Str1";
        String mname = "get" + prop;

        TwoString twoString = new TwoString("test");
        Class[] classes = new Class[]{};
        Method method = TwoString.class.getDeclaredMethod(mname, classes);
        String s = (String) method.invoke(twoString, new Object[]{});
        System.out.println(s);

        mname = "set" + prop;
        method = TwoString.class.getDeclaredMethod(mname, new Class[]{String.class});
        method.invoke(twoString, new Object[]{"true"});
        System.out.println(twoString);
    }

    @Test
    public void testArray() {
        String[] strings = {"1", "2", "3"};
        Class type = strings.getClass().getComponentType();
        int size = 5;
        Object grown = Array.newInstance(type, size);
        System.arraycopy(strings, 0, grown, 0,
                Math.min(Array.getLength(strings), size));
        System.out.println(grown);
    }

    public static String reverse(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}

class TwoString {
    private String str1;

    public TwoString(String str1) {
        this.str1 = str1;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    @Override
    public String toString() {
        return "TwoString{" +
                "str1='" + str1 + '\'' +
                '}';
    }
}
