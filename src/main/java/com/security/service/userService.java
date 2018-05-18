package com.security.service;

import com.security.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface userService {
    // 新建用户信息
    int saveUser(User user);
    // 更新用户信息
    int updateUser(User user);
    // 删除用户
    int deleteUser(Integer id);
    // 用id查询用户
    User queryUserById(Integer id);
    // 用email查询用户
    User queryUserByEmail(String Email);
    // 查询所有用户
    List<User> queryAllUser();
    // 是否存在用户
    boolean isExistUserByEmail(String Email);
    // 用email和password判断用户是否存在
    boolean verifyByEmailAndPassword(String email, String password);
}
