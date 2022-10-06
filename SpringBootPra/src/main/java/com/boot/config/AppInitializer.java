package com.boot.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Mr.wxx
 * @create 2021-06-27-8:42
 **/

/***
 * web启动初始化类
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //获取IOC容器
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        //为IOC容器中注册Spring的配置类
        webApplicationContext.register(mvcConfig.class);
        //刷新IOC容器
        webApplicationContext.refresh();
        //创建DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        //添加到servletContext中
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        //设置启动优先级，值越低越先启动
        registration.setLoadOnStartup(1);
        //添加拦截地址
        registration.addMapping("/hello/**");
    }

}
