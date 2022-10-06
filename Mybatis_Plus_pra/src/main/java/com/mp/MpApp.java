package com.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2021-06-30-14:05
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.mp.mapper"})
public class MpApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(MpApp.class, args);

    }

    @Bean
    public RestTemplate getRest(){
        return new RestTemplate();
    }
}
