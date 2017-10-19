package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    public List<User> getUserList(){
        return userDao.getUserList();
    }

    public List<User> getUserByName(String name){
        return userDao.getUserByName(name);
    }

    public  List<User> getUserById(String id){
        return userDao.getUserById(id);
    }
}
