package com.web.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.pojo.Person;

import java.io.IOException;
import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2021-06-25-23:24
 **/
public class JacksonTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("wangxu", 12);
        //读取Person对象到String中
        String s = null;
        try {
            s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

            Map map = objectMapper.readValue(s, Map.class);
            System.out.println(map);
            Person person1 = objectMapper.readValue(s, Person.class);
            System.out.println(person1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}

