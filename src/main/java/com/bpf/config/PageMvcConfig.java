package com.bpf.config;

import com.bpf.interceptor.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageMvcConfig implements WebMvcConfigurer {

    @Autowired
    private PageInterceptor pageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageInterceptor).addPathPatterns("/index")
                .addPathPatterns("/lay_right")
                .addPathPatterns("/user/reset")
                .addPathPatterns("/user/profile")
                .addPathPatterns("/mark/add");
    }
}
