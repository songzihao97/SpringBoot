package com.szh.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.szh.springboot.domain.User;
import com.szh.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public PageInfo getUser(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        PageInfo<User> allUser = userService.findAllUser(pn);
        return allUser;
    }

    @RequestMapping("/username")
    @ResponseBody
    public List<User> getUserByName(String username){
        List<User> byName = userService.findByName(username);
        return byName;
    }
}
