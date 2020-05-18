package com.szh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注主程序类，说明这是个SpringBoot应用
 */
@SpringBootApplication
public class HelloWorldMainApp {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldMainApp.class,args);
    }
}
