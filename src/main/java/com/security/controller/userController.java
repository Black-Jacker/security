package com.security.controller;

import com.security.bean.User;
import com.security.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class userController {

    @Autowired
    private userService UserService;

    // sql注入1演示
    @GetMapping(value="/login1")
    public String getLogin1(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","用户登录-sql注入1");
        return "login1";
    }
    // sql注入演示2
    @GetMapping(value="/login2")
    public String getLogin2(Model model,HttpServletRequest request){

        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null){
            model.addAttribute("user",new User());
            model.addAttribute("title","用户登录-sql注入2");
            return "login2";
        }else {
            User user = (User)session.getAttribute("user");
            model.addAttribute("user",user);
            model.addAttribute("title","login2登录成功");
            return "login2 success";
        }
    }
    // sql注入1演示
    @PostMapping(value = "/login1")
    public String postLogin1(User user, Model model, HttpServletRequest request){
        String email = user.getEmail();
        String password = user.getPassword();
        if (email==null|| email.equals("")){
            model.addAttribute("user",new User());
            model.addAttribute("title","用户登录-sql注入1");
            model.addAttribute("error","email或password不能为空！");
            return "login1";
        }
        System.out.println(email+" :" + password);

        User u = UserService.queryUserByEmail(email);

        if (UserService.isExistUserByEmail(email)) {
            if (u.getPassword().equals(password)) {
                System.out.println(u.getPassword());
                model.addAttribute("title", "登录成功,用户信息如下");
                model.addAttribute("user", u);
                HttpSession session = request.getSession();
                if (session.getAttribute("user")==null){
                    session.setAttribute("user",u);
                    System.out.println("不存在session，已设置为"+u);
                }else {
                    System.out.println(session.getAttribute("user"));
                }
                return "login1 success";
            } else {
                model.addAttribute("title", "用户登录-sql注入1");
                model.addAttribute("error", "用户名密码错误！");
                model.addAttribute("user", user);
                return "login1";
            }
        } else {
            model.addAttribute("title", "用户登录-sql注入1");
            model.addAttribute("error", "没有此用户！");
            model.addAttribute("user", user);
            return "login1";
        }
    }
    // sql注入2演示
    @PostMapping(value = "/login2")
    public String postLogin2(User user, Model model,HttpServletRequest request){
        String email = user.getEmail();
        String password = user.getPassword();
        if (email==null|| email.equals("")){
            model.addAttribute("user",new User());
            model.addAttribute("title","用户登录-sql注入2");
            model.addAttribute("error","email或password不能为空！");
            return "login2";
        }
        System.out.println(email+" :" + password);

        boolean b = UserService.verifyByEmailAndPassword(email, password);
        System.out.println(b);
        if (UserService.isExistUserByEmail(email)) {
            if (b) {
                User u = UserService.queryUserByEmail(email);
                System.out.println(u.getPassword());
                model.addAttribute("title", "登录成功,用户信息如下");
                model.addAttribute("user", u);
                HttpSession session = request.getSession();
                if (session.getAttribute("user")==null){
                    session.setAttribute("user",u);
                    System.out.println("不存在session，已设置为"+u);
                }else {
                    System.out.println(session.getAttribute("user"));
                }
                return "login2 success";
            } else {
                model.addAttribute("title", "用户登录-sql注入2");
                model.addAttribute("error", "用户名密码错误！");
                model.addAttribute("user", user);
                return "login2";
            }
        } else {
            model.addAttribute("title", "用户登录-sql注入2");
            model.addAttribute("error", "没有此用户！");
            model.addAttribute("user", user);
            return "login2";
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
        try {
            int u = UserService.saveUser(user);
            if (u>0){
                model.addAttribute("user",user);
                model.addAttribute("title","注册成功,请登录");
                return "login1";
            }else {
                model.addAttribute("Exception","未知原因");
                model.addAttribute("title","注册失败");
                return "register success";
            }

        }catch (Exception e){
            model.addAttribute("Exception",e);
            model.addAttribute("title","注册失败");
            return "register success";
        }

    }


    @GetMapping("/user")
    public String user(Model model, @RequestParam int id){
        User user = UserService.queryUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","用户信息");
        return "user";
    }

    @GetMapping("/users")
    public String user(Model model){
        List<User> list = UserService.queryAllUser();
        model.addAttribute("list",list);
        return "users";
    }

    @GetMapping("/login")
    public String getlogin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            return "redirect:/admin";
        }else {
            model.addAttribute("user",new User());
            model.addAttribute("title","g登录");
            return "login1";
        }
    }
    @PostMapping("/login")
    public String postlogin(Model model){

        return  "";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        return "admin";
    }

}
