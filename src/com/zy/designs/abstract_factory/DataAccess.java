package com.zy.designs.abstract_factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataAccess {
    public static Properties prop;
    static {
        prop = new Properties();
        String resousePath = DataAccess.class.getClassLoader().getResource("com/zy/designs/abstract_factory/properties.prop").getPath();
        try {
            prop.load(new FileReader(resousePath));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static UserDao createUserDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = prop.getProperty(UserDao.class.getSimpleName());
        Class<?> clazz = Class.forName(className);
        return (UserDao) clazz.newInstance();
    }

    public static DepartmentDao createDepartmentDao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = prop.getProperty(DepartmentDao.class.getSimpleName());
        Class<?> clazz = Class.forName(className);
        return (DepartmentDao) clazz.newInstance();
    }
}
