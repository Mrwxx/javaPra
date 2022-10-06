package com.boot.controller;

import com.boot.mapper.dao.StreamLineMapper;
import com.boot.pojo.StreamLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2021-04-12-10:10
 **/
@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    StreamLineMapper streamLineMapper;


    @RequestMapping(value = "/a")
//    @ResponseBody
    public String request1(){
        System.out.println("hello");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("a");
        modelAndView.addObject("wxx", 123);
        Example example = new Example(StreamLine.class);
        example.setDistinct(true);
        example.selectProperties("name");
        example.orderBy("name");
        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        criteria1.andLessThan("name","wxx");
        criteria2.andGreaterThanOrEqualTo("name","wxx");
        example.and(criteria2);
        streamLineMapper.selectByExample(example);
        return "a";
    }

    @RequestMapping(value = "b")
    @ResponseBody
    public ModelAndView req2(Map<String, Object> map, ModelMap modelMap, Model model){
        System.out.println("b");
        System.out.println(map == modelMap);
        System.out.println(map == model);
        System.out.println(modelMap == map);
        //异常处理
        int a = 10 / 0;
        map.put("1",2);
        modelMap.addAttribute("2",2);
        model.addAttribute("3",3);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("b");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String handlerException(Exception ex){
        System.out.println(ex.getMessage());
        //跳转到error页面
        return "error";
    }
}
