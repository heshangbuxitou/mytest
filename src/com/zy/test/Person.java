package com.zy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class Person {
    private static final Logger logger = Logger.getLogger(Employee.class.getName());
//    private String name;
    public static final String GENDER_MALE = "MALE";
    public static final String GENDER_FEMALE = "FEMALE";

    private int age;
    private int height;
    private int weight;
    private String firstName;
    public static Logger getLogger(){
        return logger;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return getFirstName().concat(" ").concat(getLastName());
    }

    private String lastName;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        int ret = height;
        // If locale of the computer this code is running on is U.S.,
        if (Locale.getDefault().equals(Locale.US)){
            ret /= 2.54;
        }
        return ret;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String eyeColor;
    private String gender;
    public Person(){}
    public Person(String firstName,String lastName, int age, int height, int weight, String eyeColor, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.gender = gender;
    }

    public void printAudit(StringBuilder buffer) {
        buffer.append("Name="); buffer.append(getFullName());
        buffer.append(","); buffer.append("Age="); buffer.append(getAge());
        buffer.append(","); buffer.append("Height="); buffer.append(getHeight());
        buffer.append(","); buffer.append("Weight="); buffer.append(getWeight());
        buffer.append(","); buffer.append("EyeColor="); buffer.append(getEyeColor());
        buffer.append(","); buffer.append("Gender="); buffer.append(getGender());
    }
    public void printAudit(Logger l) {
        StringBuilder sb = new StringBuilder();
        printAudit(sb);
        l.info(sb.toString());
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (height != person.height) return false;
        if (weight != person.weight) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (eyeColor != null ? !eyeColor.equals(person.eyeColor) : person.eyeColor != null) return false;
        return gender != null ? gender.equals(person.gender) : person.gender == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Logger l = Logger.getLogger(Person.class.getName());
        String greeting = new String("hello");
        l.info(greeting);
        Person p = new Person("Joe", "Q Author", 42, 173, 82, "Brown", "MALE");
        p.printAudit(l);
        p = new Person();
        l.info(Person.GENDER_FEMALE);

    }
}
