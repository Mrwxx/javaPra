package com.mrwxx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mr.wxx
 * @create 2021-04-12-10:10
 **/
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/a")
//    @ResponseBody
    public String request1(){
        System.out.println("hello");
        return "a";
    }
}
