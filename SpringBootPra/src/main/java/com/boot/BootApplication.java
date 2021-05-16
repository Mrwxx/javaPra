package com.boot;

import com.boot.pojo.Car;
import com.boot.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Mr.wxx
 * @create 2021-04-27-10:06
 **/

@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(BootApplication.class, args);
        User bean = ioc.getBean(User.class);
        System.out.println(bean);

        Car car = ioc.getBean(Car.class);
        System.out.println(car);
    }
}
