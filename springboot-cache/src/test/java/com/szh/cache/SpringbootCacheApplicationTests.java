package com.szh.cache;

import com.szh.cache.dao.EmployeeMapper;
import com.szh.cache.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate myRedisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee);
    }

    @Test
    public void testRedis(){
        //将数据存入redis
       /* stringRedisTemplate.opsForValue().append("msg","world");*/
        //取出数据
       /* String s = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(s);*/
       stringRedisTemplate.opsForList().rightPushAll("myList","1","2","3","4");
    }

    @Test
    public void testRedisObject(){
        /*Employee employee = employeeMapper.selectByPrimaryKey(1);
        myRedisTemplate.opsForValue().set("emp",employee);*/
        myRedisTemplate.opsForList().rightPushAll("mylist",1,2,2,4);
    }


    @Test
    public void testRedisChar(){
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        myRedisTemplate.opsForValue().set("emp",employee);
    }
}
