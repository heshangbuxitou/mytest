package com.zy.designs.decoration;

public class Finery extends Person {
    Person person;
    public void setPerson(Person person){
        this.person = person;
    }

    @Override
    public void show() {
        if(person != null){
            person.show();
        }
    }
}
