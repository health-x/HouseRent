package com.house.health.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射图片保存地址   file:E:/picture/租房/
        // 获取 webapp目录
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/houseImages/");
    }
}
