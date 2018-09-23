package com.zy.designs.interpreter;

import com.zy.designs.abstract_factory.DataAccess;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ExpressionFactory {
    public static Properties prop;
    static {
        prop = new Properties();
        String resousePath = DataAccess.class.getClassLoader().getResource("com/zy/designs/interpreter/properties.prop").getPath();
        try {
            prop.load(new FileReader(resousePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Expression createExpression(PlayContext context) {
        try {
            String className = prop.getProperty(context.getText().substring(0, 1));
            Class<?> clazz = Class.forName(className);
            return (Expression) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
