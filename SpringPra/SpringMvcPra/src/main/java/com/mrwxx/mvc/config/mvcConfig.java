package com.mrwxx.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Mr.wxx
 * @create 2021-06-27-7:18
 **/
@Configuration
@ComponentScan(basePackages = "com.mrwxx.mvc")
@EnableWebMvc
public class mvcConfig {

    @Bean
    public InternalResourceViewResolver getInter(){
        //视图解析器，设置前缀，后缀
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }
}
