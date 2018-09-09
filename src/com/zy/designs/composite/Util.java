package com.zy.designs.composite;

public class Util {
    public static String getNumString(String s,int num){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<num;i++){
            sb.append(s);
        }
        return sb.toString();
    }
}
