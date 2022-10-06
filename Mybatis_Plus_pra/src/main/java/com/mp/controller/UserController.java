package com.mp.controller;

import com.mp.mapper.MyMapper;
import com.mp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mr.wxx
 * @create 2021-06-30-14:23
 **/
@Controller
public class UserController {
    @Autowired
    private MyMapper myMapper;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        User wangxu = new User("wangxu", 22, "huangshi");


        int insert = myMapper.insert(wangxu);

        return String.valueOf(insert);
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String test3(){
        User wangxu = new User("wangxu", 22, "huangshi");

        User user = myMapper.selectOne("user5", "wangxu");
        return user.toString();
    }

}








