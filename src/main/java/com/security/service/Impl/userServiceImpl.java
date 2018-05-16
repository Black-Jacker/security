package com.security.service.Impl;

import com.security.bean.User;
import com.security.dao.userDAO;
import com.security.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDAO userDao;

    @Override
    public int saveUser(User user) {
        return userDao.add(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryById(id);
    }

    @Override
    public User queryUserByEmail(String email){
        return userDao.queryByEmail(email);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAll();
    }

    @Override
    public boolean isExistUserByEmail(String Email) {
        return userDao.isExistUserByEmail(Email);
    }


}
