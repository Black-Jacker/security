package com.security.controller;

import com.security.domain.User;
import com.security.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class userController {

    @Autowired
    private userService UserService;

    @GetMapping(value="/login")
    public String getLogin(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","用户登录");
        return "login";
    }
    @PostMapping(value = "/login")
    public String postLogin(User user, Model model){
        String email = user.getEmail();
        String password = user.getPassword();
        if (email==null|| email.equals("")){
            return "login";
        }
        System.out.println(email+" :" + password);
        User u = UserService.queryUserByEmail(email);
        if (u.getPassword().equals(password)){
            model.addAttribute("title","登录成功");
            model.addAttribute("user",u);
            return "login success";
        }else {
            return "redirect:/notVerify";
        }
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title","用户注册");
        return "register";
    }
    @PostMapping("/register")
    public String postRegister(User user,Model model){
        User u = UserService.saveUser(user);
        model.addAttribute("user",u);
        model.addAttribute("title","注册成功");
        return "register success";
    }

    @RequestMapping("/notVerify")
    public String notVerify(){
        return "username or password not correct";
    }
}
