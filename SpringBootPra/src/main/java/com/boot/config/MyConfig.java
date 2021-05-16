package com.boot.config;

import com.boot.pojo.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.wxx
 * @create 2021-04-27-14:17
 **/
@Configuration
@ConditionalOnMissingBean(value = {User.class})
public class MyConfig {

    @Bean
    public User tom(){
        return new User(12, "wx");
    }
}
