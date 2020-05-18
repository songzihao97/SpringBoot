package com.szh.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szh.springboot.dao")
public class SpringBootMybatisGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisGeneratorApplication.class, args);
    }

}
