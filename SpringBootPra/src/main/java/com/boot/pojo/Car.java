package com.boot.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-04-27-14:48
 **/

@ConfigurationProperties(prefix = "mycar")
@Component
public class Car {
    @Value("${mycar.age}")
    private int price;
    private int age;

    public Car() {
    }

    public Car(int price, int age) {
        this.price = price;
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", age=" + age +
                '}';
    }
}
