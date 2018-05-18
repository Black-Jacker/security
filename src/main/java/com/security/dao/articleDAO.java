package com.security.dao;

import com.security.bean.Article;

import java.util.List;

public interface articleDAO {
    public int add(Article article);

    public int update(Article article);

    int delete(int id);

    Article queryById(String id);

    List<Article> queryAll();

    List<Article> queryAllByUser(int user_id);
}
