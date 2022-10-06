package com.mrwxx.mvc;

import com.mrwxx.mvc.config.RootConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Mr.wxx
 * @create 2021-06-27-7:48
 **/

public class MvcApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        annotationConfigApplicationContext.start();
    }
}
