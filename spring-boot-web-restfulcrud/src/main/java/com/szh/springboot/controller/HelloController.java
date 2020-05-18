package com.szh.springboot.controller;

import com.szh.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

/*    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }*/

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好<h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
