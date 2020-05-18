package com.szh.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable error = getError(webRequest);
        if (error!=null){
            map.put("exception",error.getClass().getName());
        }
        Map<String,Object> ext= (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        map.put("company","szh");
        return map;
    }
}
