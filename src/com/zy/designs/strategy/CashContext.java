package com.zy.designs.strategy;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;

public class CashContext {
    private CashSuper cs;
    public static Properties prop;

    static {
        prop = new Properties();
        String resousePath = CashContext.class.getClassLoader().getResource("com/zy/designs/strategy/properties.prop").getPath();
        try {
            prop.load(new FileReader(resousePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //  工厂版
    //    public CashContext(String type){
//        switch (type){
//            case "正常收费":
//                cs = new CashNormal();
//                break;
//            case "满300返100":
//                cs = new CashReturn("300", "100");
//                break;
//            case "打八折":
//                cs = new CashRebate("0.8");
//                break;
//            default:
//                throw new RuntimeException("请输入正确的值。。");
//        }
//    }
    //反射版
    public CashContext(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String classAndParam = prop.getProperty(type);
        String[] params = classAndParam.split(";");
        String className = params[0];
        Class<?> clazz = Class.forName(className);

        Class[] StringsClass = new Class[params.length - 1];
        for (int i = 0; i < StringsClass.length; i++) {
            StringsClass[i] = String.class;
        }

        Constructor<?> method = clazz.getDeclaredConstructor(StringsClass);
        cs = (CashSuper) method.newInstance(Arrays.copyOfRange(params, 1, params.length));
    }


    public double getResult(double money) {
        return cs.accept(money);
    }
}
