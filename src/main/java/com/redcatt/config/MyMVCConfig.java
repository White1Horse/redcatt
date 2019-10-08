package com.redcatt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/regist.html").setViewName("regist");
        registry.addViewController("/select.html").setViewName("select");
        registry.addViewController("/main.html").setViewName("main");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login**", "/regist**","/img**");
    }
}
