package com.szh.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public List testDruid(){
        String sql="select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
}
