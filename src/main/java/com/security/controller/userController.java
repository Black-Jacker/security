package com.security.controller;

import com.security.domain.userDAO;
import com.security.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class userController {

    @Autowired
    private userDAO userDAO;
    private userService userServic;

    @GetMapping(value="/login")
    public String getLogin(){
        return "login";
    }
    @PostMapping(value = "/login")
    public String postLogin(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email==null|| email.equals("")){

            return "login";
        }
        System.out.println(email+" :" + password);
        userDAO user = userServic.queryUserByEmail(email);
        if (user.getPassword().equals(password)){
            return "login success";
        }else {
            return "login";
        }
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
