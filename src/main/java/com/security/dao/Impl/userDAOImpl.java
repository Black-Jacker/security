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

@Repository("userDAO")
public class userDAOImpl implements userDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException{
            User user = new User();


            user.setId(rs.getString("id"));
            user.setEmail(rs.getString("email"));
            user.setNickname(rs.getString("nickname"));
            user.setPhoneno(rs.getString("phoneno"));
            user.setPasswd(rs.getString("passwd"));
            user.setStatus(rs.getString("status"));
            return user;
        }
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public User queryById(int id) {
        return null;
    }

    @Override
    public User queryByEmail(String email) {
        String sql = "select * from users where email= '"+email+"'";
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());

        if (null!=list && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        List<User> list = jdbcTemplate.query("select * from users where email='"+email+"'",new UserRowMapper());
        if (null!=list && !list.isEmpty()){
            return true;
        }
        return false;
    }
}
