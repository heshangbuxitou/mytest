package com.zy.test;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipeStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("c://webroot");
        for(File sonFile: file.listFiles()){
            System.out.println(sonFile.getName());
        }
    }

    public static void process(InputStream inputStream) throws IOException {
        byte[] readBuffer = new byte[1024];
        int readOffset = 0;
        StringBuilder sb = new StringBuilder();
        while ((readOffset = inputStream.read(readBuffer)) > 0){
            sb.append(new String(readBuffer, 0, readOffset));
        }
        System.out.println(sb);
    }
}
