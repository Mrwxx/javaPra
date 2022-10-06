package com.boot.config;

import com.boot.interceptor.First;
import com.boot.interceptor.Second;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * @author Mr.wxx
 * @create 2021-06-27-7:18
 **/

/***
 * MVC的配置类
 */
@Configuration
@ComponentScan(basePackages = "com.boot")
@EnableWebMvc
public class mvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver getInter(){
        //视图解析器，设置前缀，后缀
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/html/");
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }

    //添加Tomcat服务器中的DefaultServlet
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        //启动DefaultServlet
//        configurer.enable();
//    }

    //用ResourceHttpRequestHandler来处理静态资源。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
    }

    @Bean
    public HiddenHttpMethodFilter getHidden(ServletContext context){
        HiddenHttpMethodFilter hmf = new HiddenHttpMethodFilter();
        FilterConfig filterConfig = hmf.getFilterConfig();
        return hmf;
    }

    @Bean
    public ConversionServiceFactoryBean getCon(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
//        conversionServiceFactoryBean.setConverters();
        return conversionServiceFactoryBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        First first = new First();
        Second second = new Second();
        registry.addInterceptor(first).addPathPatterns("/**");
        registry.addInterceptor(second).addPathPatterns("/**");
    }

}


