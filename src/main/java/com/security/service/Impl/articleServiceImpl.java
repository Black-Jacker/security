package com.security.service.Impl;

import com.security.bean.Article;
import com.security.dao.articleDAO;
import com.security.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class articleServiceImpl implements articleService {
    @Autowired
    private articleDAO articleDao;

    @Override
    public int add(Article article) {
        return articleDao.add(article);
    }

    @Override
    public int delete(int id) {
        return articleDao.delete(id);
    }

    @Override
    public int update(Article article) {
        return articleDao.update(article);
    }

    @Override
    public Article queryById(String id) {
        return articleDao.queryById(id);
    }

    @Override
    public List<Article> queryAll() {
        return articleDao.queryAll();
    }

    @Override
    public List<Article> queryAllByUser(int user_id) {
        return articleDao.queryAllByUser(user_id);
    }
}
