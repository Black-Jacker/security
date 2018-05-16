package com.security.service;

import com.security.domain.User;
import org.springframework.stereotype.Service;

@Service("userService")
public interface userService {
    // 新建用户信息
    User saveUser(User user);
    // 更新用户信息
    User updateUser(User user);
    // 删除用户
    int deleteUser(Integer id);
    // 用id查询用户
    User queryUserById(Integer id);
    // 用email查询用户
    User queryUserByEmail(String Email);

}
