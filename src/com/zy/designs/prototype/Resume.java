package com.zy.designs.prototype;

public class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private String timeArea;
    private String company;

    public Resume(String name) {
        this.name = name;
    }

    public void setPersonalInfo(String sex, String age){
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String timeArea, String  company){
        this.timeArea = timeArea;
        this.company = company;
    }

    public void show(){
        System.out.println(name + " " + sex + " " + age);
        System.out.println(timeArea + " " + company);
    }

    @Override
    public Object clone() {
        Resume obj = null;
        try{
            obj = (Resume) super.clone();
            System.out.println("我被克隆了。。。。");
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return obj;
    }
}
