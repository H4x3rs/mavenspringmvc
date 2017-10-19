package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.example.model.User;
import org.springframework.jdbc.core.RowCallbackHandler;

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
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                User u=new User();
                u.setId(resultSet.getString(1));
                u.setEmail(resultSet.getString(2));
                u.setPassword(resultSet.getString(3));
                u.setPhone(resultSet.getString(4));
                u.setCreate_at(resultSet.getString(5));
                u.setNickname(resultSet.getString(6));
                listAllUser.add(u);
            }
        });
        return listAllUser;
    }

    public User queryUser(String id){
        String sql="select *FROM users where id=?";
        return null;
    }
}
