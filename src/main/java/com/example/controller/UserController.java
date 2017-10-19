package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<User> userList = userService.getUserList();
        request.setAttribute("userlist",userList);
        return "getAll";
    }

    @RequestMapping(params = "method=findUser")
    public String findUser(HttpServletRequest request){
        String id = request.getParameter("id");
        List<User> userlist = userService.getUserById(id);
        request.setAttribute("userlist", userlist);
        return "getAll";
    }

}
