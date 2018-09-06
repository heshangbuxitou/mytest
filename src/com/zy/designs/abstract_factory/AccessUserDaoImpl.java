package com.zy.designs.abstract_factory;

public class AccessUserDaoImpl implements UserDao{
    @Override
    public User getUserById(int id) {
        System.out.println("AccessUserDaoImpl 的 getUserById 方法");
        return null;
    }

    @Override
    public void insertUser(User user) {
        System.out.println("AccessUserDaoImpl 的 insertUser 方法");
    }
}
