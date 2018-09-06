package com.zy.designs.template;

public abstract class ExamSuper {
    abstract String answer1();

    abstract String answer2();

    abstract String answer3();

    public void examQuestion1() {
        System.out.println("驾驶机动车在道路上违反道路交通安全法的行为，属于什么行为？\n" +
                "A：违章行为\n" +
                "B：违法行为\n" +
                "C：过失行为\n" +
                "D：违规行为");
        System.out.println("答案：" + answer1());
    }

    public void examQuestion2() {
        System.out.println("机动车驾驶人违法驾驶造成重大交通事故构成犯罪的，依法追究什么责任？\n" +
                "A：刑事责任\n" +
                "B：民事责任\n" +
                "C：经济责任\n" +
                "D：直接责任");
        System.out.println("答案：" + answer2());
    }

    public void examQuestion3() {
        System.out.println("机动车驾驶人造成事故后逃逸构成犯罪的，吊销驾驶证且多长时间不得重新取得驾驶证？\n" +
                "A：5年内\n" +
                "B：10年内\n" +
                "C：终生\n" +
                "D：20年内");
        System.out.println("答案：" + answer3());
    }
}
