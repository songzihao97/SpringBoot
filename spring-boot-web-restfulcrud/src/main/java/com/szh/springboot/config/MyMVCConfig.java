package com.szh.springboot.config;

import com.szh.springboot.component.LoginHandlerInterceptor;
import com.szh.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springMVC功能
@Configuration
public class MyMVCConfig implements WebMvcConfigurer{

    //添加自定义视图解析
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送atS请求来到success
        registry.addViewController("/atS").setViewName("success");
    }

    //重定义一个MVC配置
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer=new WebMvcConfigurer() {
            //自定义视图解析
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            /*//配置拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //配置登录拦截器
                //springboot已经做好了静态资源放行映射，不用再次配置
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/css/**","/webjars/**","/asserts/**");
            }*/
        };
        return  configurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //设置资源拦截
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }*/
}
