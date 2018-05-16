package com.security.service.Impl;

import com.security.domain.User;
import com.security.service.userService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String phone = user.getPhone();

        String sql = "insert into user(name, email, password, phone) values(?,?,?,?);";
        int row = jdbcTemplate.update(sql,name,email,password,phone);
        if(row == 1){
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public int deleteUser(Integer id) {
        return 0;
    }

    @Override
    public User queryUserById(Integer id) {
        return null;
    }

    @Override
    public User queryUserByEmail(String Email) {
        String sql = "select * from user where email="+ Email;
        User user = (User)jdbcTemplate.queryForMap(sql);
        return user;
    }
}
