package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }

    @RequestMapping("/getAll")
    public String getall(HttpServletRequest request){
        List<User> userList = userDao.queryAll();
        request.setAttribute("userlist",userList);
        return "getAll";
    }
}
