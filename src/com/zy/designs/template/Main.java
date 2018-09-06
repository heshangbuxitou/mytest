package com.zy.designs.template;

public class Main {
    public static void main(String[] args) {
        /**
         *  模板方法模式 他定义的是一个操作中的算法骨架，而将变化的地方延迟到子类加载
         *  子类 需要实现的只是 变化的地方
         *  此处使用考试答题的例子来演示
          */
        System.out.println("考生1");
        examTOAnswer(new ExamStudent1());
        System.out.println("考生2");
        examTOAnswer(new ExamStudent2());
    }

    public static void examTOAnswer(ExamSuper student){
        student.examQuestion3();
        student.examQuestion2();
        student.examQuestion1();
    }
}
