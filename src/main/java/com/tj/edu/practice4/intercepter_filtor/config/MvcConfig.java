package com.tj.edu.practice4.intercepter_filtor.config;

import com.tj.edu.practice4.intercepter_filtor.interceptors.Authinterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final Authinterceptor authinterceptor;

    public MvcConfig(Authinterceptor authinterceptor){
        this.authinterceptor = authinterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(authinterceptor);
    }
}
