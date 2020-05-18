package com.szh.springboot.controller;

import com.szh.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器服务器返回的都死json
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notExist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    //自适应（转发到/error交给springboot处理）
    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notExist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
