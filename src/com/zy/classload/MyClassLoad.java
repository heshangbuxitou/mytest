package com.zy.classload;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassLoad extends ClassLoader {

    public String classpath;

    public MyClassLoad(String classpath) {
        this.classpath = classpath;
    }

    public byte[] loadByte(String name) throws FileNotFoundException {
        name = name.replaceAll("\\.", "/");
        try (FileInputStream fileInputStream = new FileInputStream(classpath + "/" + name + ".class")) {
            int len = fileInputStream.available();
            byte[] data = new byte[len];
            fileInputStream.read(data);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        }
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(data, 0, data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
