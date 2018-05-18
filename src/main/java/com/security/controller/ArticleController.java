package com.security.controller;


import com.security.bean.Article;
import com.security.bean.User;
import com.security.dao.userDAO;
import com.security.service.articleService;
import com.security.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private userService UserService;
    @Autowired
    private articleService ArticleService;

    @GetMapping("/article")
    public String getArticle(Model model,String id){
        id = id==null?"1":id;
        System.out.println(id);
        Article article = ArticleService.queryById(id);
        User user = UserService.queryUserById(article.getUser_id());
        System.out.println(user.getName());
        model.addAttribute("article",article);
        model.addAttribute("user",user);
        return "article";
    }

    @GetMapping("/editArticle")
    public String addArticle(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null){
            return "redirect:/login2";
        }else {
            Article article = new Article();
            User user = (User)session.getAttribute("user");
            article.setUser_id(user.getId());
            model.addAttribute("title","新建文章");
            model.addAttribute("article",article);
            model.addAttribute("user",session.getAttribute("user"));
            return "edit article";
        }
    }
    @PostMapping("/editArticle")
    public String postArticle(Model model,Article article){
        int a = ArticleService.add(article);
        return "redirect:/allArticle";
    }

    @RequestMapping("/allArticle")
    public String allArticle(Model model){
        List<Article> list = ArticleService.queryAll();
        for (Article article:list){
            User user = UserService.queryUserById(article.getUser_id());
        }
        System.out.println(list.get(0).getTitle());
        model.addAttribute("list",list);
        return "allArticle";
    }

}
