package com.security.dao.Impl;

import com.security.bean.User;
import com.security.dao.userDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class userDAOImpl implements userDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException{
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
            user.setPhone(rs.getString("phone"));
            user.setPassword(rs.getString("password"));

            return user;
        }
    }

    @Override
    public int add(User user) {
        String name = user.getName();
        String password = user.getPassword();
        String phone = user.getPhone();
        String email = user.getEmail();
        String sql = "insert into user(name,password,phone,email) values(?,?,?,?)";
        System.out.println(sql);
        int r = jdbcTemplate.update(sql,new Object[]{name,password,phone,email});
        return r;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from user where id = ?";
        System.out.println(sql);
        int r = jdbcTemplate.update(sql,id);
        return r;
    }

    @Override
    public User queryById(int id) {
        String sql = "select * from user where id= '"+id+"'";
        System.out.println(sql);
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());

        if (null!=list && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User queryByEmail(String email) {
        String sql = "select * from user where email= '"+email+"'";
        System.out.println(sql);
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());

        if (null!=list && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> queryAll() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new UserRowMapper());
        return list;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        String sql = "select * from user where email='"+email+"'";
        System.out.println(sql);
        List<User> list = jdbcTemplate.query(sql, new UserRowMapper());
        if (null!=list && !list.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyByEmailAndPassword(String email, String password) {
        String sql = "select * from user where email='"+email+"'and password = '"+password+"'";
        System.out.println(sql);
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());
        if (null!=list && !list.isEmpty()){
            return true;
        }
        return false;
    }
}
