package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> queryAll(){
        String sql = "select * from users";
        List<User> listAllUser = new ArrayList<User>();
        listAllUser = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setPhone(resultSet.getString("phoneno"));
                user.setCreate_at(resultSet.getString("create_at"));
                return user;
            }
        });
        return listAllUser;
    }

    public User queryUser(String id){
        String sql="select *FROM users where id=?";
        return null;
    }
}
