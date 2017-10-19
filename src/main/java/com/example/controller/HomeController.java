package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("index")
    public String index(){
        logger.info("the first jsp pages");
        return "index";
    }

    @RequestMapping("user")
    public String user(){

        return "user";
    }

}