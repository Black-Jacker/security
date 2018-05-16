package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "welcome first spring boot project";
    }
}
