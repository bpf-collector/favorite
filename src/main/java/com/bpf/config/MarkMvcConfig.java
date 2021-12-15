package com.bpf.config;

import com.bpf.interceptor.MarkInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MarkMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MarkInterceptor markInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(markInterceptor).addPathPatterns("/mark/**")
                .addPathPatterns("/link/**");
    }
}
