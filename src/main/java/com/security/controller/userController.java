package com.security.controller;

import com.security.bean.User;
import com.security.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.alibaba.druid.util.StringUtils;
import sun.swing.StringUIClientPropertyKey;

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
        String password = user.getPasswd();
        if (email==null|| email.equals("")){
            model.addAttribute("user",new User());
            model.addAttribute("title","用户登录-sql注入");
            model.addAttribute("error","email或password不能为空！");
            return "login";
        }
        System.out.println(email+" :" + password);

        User u = UserService.queryUserByEmail(email);

        if (UserService.isExistUserByEmail(email)) {
            if (u.getPasswd().equals(password)) {
                System.out.println(u.getPasswd());
                model.addAttribute("title", "登录成功,用户信息如下");
                model.addAttribute("user", u);
                return "login success";
            } else {
                model.addAttribute("title", "用户登录");
                model.addAttribute("error", "用户名密码错误！");
                model.addAttribute("user", user);
                return "login";
            }
        } else {
            model.addAttribute("title", "用户登录");
            model.addAttribute("error", "没有此用户！");
            model.addAttribute("user", user);
            return "login";
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
        int u = UserService.saveUser(user);
        model.addAttribute("user",u);
        model.addAttribute("title","注册成功");
        return "register success";
    }

    @RequestMapping("/notVerify")
    @ResponseBody
    public String notVerify(){
        return "username or password not correct";
    }
}
