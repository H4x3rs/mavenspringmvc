package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.example.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(value = "userDao")
public class UserDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<User> getUserList(){
        String sql = "select * from users";
        List<User> listAllUser = new ArrayList<User>();
        listAllUser = jdbcTemplate.query(sql, new UserRowMapper());
        return listAllUser;
    }

    //通过用户名关键字获取用户列表
    public List<User> getUserByName(String name){
        List<User> userlist = new ArrayList<User>();
        String sql = "select *from users where nickname like ?";

        userlist = jdbcTemplate.query(sql, new Object[]{"%"+name+"%"}, new UserRowMapper());
        return userlist;
    }

    // 通过id获取用户
    public  List<User> getUserById(String id){
        String sql="select *from users where id=?";
        return jdbcTemplate.query(sql,new Object[]{id}, new UserRowMapper());
    }

    //匿名内部类
    public class UserRowMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException{
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setNickname(resultSet.getString("nickname"));
            user.setPhone(resultSet.getString("phoneno"));
            user.setCreate_at(resultSet.getString("create_at"));
            return user;
        }

    }

}
