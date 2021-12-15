package com.bpf.config;

import com.bpf.interceptor.UserDeleteInterceptor;
import com.bpf.interceptor.UserGetInterceptor;
import com.bpf.interceptor.UserUpdateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 用户拦截器
 *
 * 1. 拦截 /user/delete/{id}
 *      权限必须是 管理员
 * 2. 拦截 /user/update/{id}?password=xxx
 *      权限是管理员 或 权限是普通用户，但只能修改自己的
 * 3. 拦截 /user/get/{id}
 *      权限是管理员 或 权限是普通用户，但只能查看自己的
 */
@Configuration
public class UserMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UserDeleteInterceptor userDeleteInterceptor;
    @Autowired
    private UserUpdateInterceptor userUpdateInterceptor;
    @Autowired
    private UserGetInterceptor userGetInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userDeleteInterceptor).addPathPatterns("/user/delete/**");
        // registry.addInterceptor(userUpdateInterceptor).addPathPatterns("/user/update/**");
        registry.addInterceptor(userGetInterceptor).addPathPatterns("/user/get/**");
    }
}
