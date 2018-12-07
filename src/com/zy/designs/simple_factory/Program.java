package com.zy.designs.simple_factory;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入数字A：");
            String strNumberA = in.readLine();
            System.out.println("请选择运算符号(+,-,*,/)：");
            String strOperate = in.readLine();
            System.out.println("请输入数字B：");
            String strNumberB = in.readLine();
            String strResult = "";
            switch (strOperate) {
                case "+":
                    strResult = Double.parseDouble(strNumberA) + Double.parseDouble(strNumberB) + "";
                    break;
                case "-":
                    strResult = Double.parseDouble(strNumberA) - Double.parseDouble(strNumberB) + "";
                    break;
                case "*":
                    strResult = Double.parseDouble(strNumberA) * Double.parseDouble(strNumberB) + "";
                    break;
                case "/":
                    strResult = Double.parseDouble(strNumberA) / Double.parseDouble(strNumberB) + "";
                    break;
                default:
                    throw new RuntimeException("请输入正确的操作符号..");
            }
            System.out.println("计算结果为：" + strResult);
        } catch (Exception e) {
            System.out.println("你的输入有误，请重新输入。。" + e.getMessage());
        }
    }
}
