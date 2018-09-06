package com.zy.designs.abstract_factory;

public class SSUserDaoImpl implements UserDao {
    @Override
    public User getUserById(int id) {
        System.out.println("SSUserDaoImpl 的 getUserById 方法");
        return null;
    }

    @Override
    public void insertUser(User user) {
        System.out.println("SSUserDaoImpl 的 insertUser 方法");
    }
}
