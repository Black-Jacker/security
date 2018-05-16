package com.security.service;

import com.security.domain.userDAO;
import org.springframework.stereotype.Service;

@Service("userService")
public interface userService {
    // 新建用户信息
    userDAO saveUser(userDAO user);
    // 更新用户信息
    userDAO updateUser(userDAO user);
    // 删除用户
    int deleteUser(Integer id);
    // 用id查询用户
    userDAO queryUserById(Integer id);
    // 用email查询用户
    userDAO queryUserByEmail(String Email);

}
