package com.zy.designs.abstract_factory;

public interface UserDao {
    User getUserById(int id);
    void insertUser(User user);
}
