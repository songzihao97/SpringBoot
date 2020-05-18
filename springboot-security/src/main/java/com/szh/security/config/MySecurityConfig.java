package com.szh.security.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置登录功能
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin")/*.loginProcessingUrl("/login")*/;//设置自定义登录页面
        //开启自动配置推出功能
        http.logout().logoutSuccessUrl("/");//注销成功后来到首页
        //开启记住用户功能
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("{noop}123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("{noop}123456").roles("VIP2","VIP3")
                .and()
                .withUser("wangwu").password("{noop}123456").roles("VIP1","VIP3");
    }
}
