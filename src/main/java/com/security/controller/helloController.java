package com.security.controller;

import com.security.domain.userDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @RequestMapping("/hello")
    public userDAO hello(){
        userDAO user = new userDAO();
        user.setId(1);
        user.setName("Tom");
        user.setEmail("Tom@gamil.com");
        user.setPassword("123456");
        user.setPhone("12345678911");

        return user;
    }
}
