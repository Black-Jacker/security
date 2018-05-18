package com.security.dao.Impl;

import com.security.bean.Article;
import com.security.dao.articleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("articleDAO")
public class articleDAOImpl implements articleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Article article) {
        String title = article.getTitle();
        String content = article.getContent();
        int user_id = article.getUser_id();
        String sql = "insert into article(title,content,user_id) values(?,?,?)";
        System.out.println(sql);
        int r = jdbcTemplate.update(sql,new Object[]{title,content,user_id});
        return r;
    }

    @Override
    public int update(Article article) {
        return 0;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from article where id ='"+id+"'";
        System.out.println(sql);
        int r = jdbcTemplate.update(sql);
        return r;
    }

    @Override
    public Article queryById(String id) {
        String sql = "select * from article where id="+id;
        System.out.println(sql);
        List<Article> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Article.class));
        return list.get(0);
    }

    @Override
    public List<Article> queryAll() {
        String sql = "select * from article";
        System.out.println(sql);
        List<Article> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Article.class));
        return list;
    }

    @Override
    public List<Article> queryAllByUser(int user_id) {
        return null;
    }
}
