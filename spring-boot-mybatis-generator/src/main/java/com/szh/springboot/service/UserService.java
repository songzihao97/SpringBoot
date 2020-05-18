package com.szh.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.szh.springboot.dao.UserMapper;
import com.szh.springboot.domain.User;
import com.szh.springboot.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public PageInfo<User> findAllUser(Integer pn){
        PageHelper.startPage(pn,10);
        List<User> users = userMapper.selectByExample(null);
        PageInfo page=new PageInfo(users);
        return page;
    }

    public List<User> findByName(String username){
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        UserExample.Criteria or = example.or();
        criteria.andUsernameEqualTo(username);
        or.andPasswordEqualTo("12345");
        List<User> users = userMapper.selectByExample(example);
        return users;
    }
}
