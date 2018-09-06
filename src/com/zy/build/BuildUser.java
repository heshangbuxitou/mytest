package com.zy.build;

import com.zy.domain.User;

import java.util.Date;

public class BuildUser {
    private String name = "test";
    private String password = "test";
    private String email = "test";
    private Date birthday = new Date();
    public BuildUser(){
        System.out.println(name);
    }

    public User buildUser(){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthday(birthday);
        return user;
    }
}
