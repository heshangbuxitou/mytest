package com.zy.test;

import java.io.*;

public class CloneUtils {
    private CloneUtils() {

    }
    public static <T extends Serializable> T clone(T obj) throws IOException, ClassNotFoundException {
        try(
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bout);
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bin);
            ) {
            oos.writeObject(obj);
            return (T) ois.readObject();
        }
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
}
