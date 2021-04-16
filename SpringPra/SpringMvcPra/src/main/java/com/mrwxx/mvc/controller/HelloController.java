package com.mrwxx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.wxx
 * @create 2021-04-12-10:10
 **/
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String request1(){
        System.out.println("hello");
        return "a";
    }
}
