package com.mrwxx.mvc.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.swing.*;

/**
 * @author Mr.wxx
 * @create 2021-06-27-7:36
 **/
@Component
public class DisInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new  Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{mvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //默认是/，表示拦截所有请求
        return new String[]{"/"};
    }
}
