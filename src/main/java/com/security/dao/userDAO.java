package com.security.dao;

import com.security.bean.User;

import java.util.List;

public interface userDAO{
    public int add(User user);

    public int update(User user);

    public int delete(int id);

    User queryById(int id);

    User queryByEmail(String email);

    public List<User> queryAll();

    boolean isExistUserByEmail(String email);

    boolean verifyByEmailAndPassword(String email, String password);
}
