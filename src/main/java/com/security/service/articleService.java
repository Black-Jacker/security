package com.security.service;

import com.security.bean.Article;

import java.util.List;

public interface articleService {
    // 新建article
    int add(Article article);
    //删除article
    int delete(int id);
    // 更新article
    int update(Article article);
    // 查询article by id
    Article queryById(String id);
    // 查询article 所有
    List<Article> queryAll();
    // 查询用户article
    List<Article> queryAllByUser(int user_id);

}
