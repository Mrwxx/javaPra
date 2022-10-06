package wxx.javaPra.anno.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import wxx.javaPra.anno.contidion.LinuxCondition;
import wxx.javaPra.anno.contidion.MyImport;
import wxx.javaPra.anno.contidion.WinCondition;
import wxx.javaPra.anno.factoryBean.YellowFac;
import wxx.javaPra.anno.out.Red;
import wxx.javaPra.anno.pojo.Person;

/**
 * @author Mr.wxx
 * @create 2021-04-17-8:31
 **/
@Configuration
//@ComponentScan(value = "wxx.javaPra.anno",excludeFilters = {@ComponentScan.Filter
//        (type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})} )
//@ComponentScan(value = "wxx.javaPra.anno",includeFilters = {@ComponentScan.Filter
//        (type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})},useDefaultFilters = false)
@ComponentScan(value = "wxx.javaPra.anno",includeFilters = {@ComponentScan.Filter
        (type = FilterType.CUSTOM,classes = {MyTypeFilter.class}) },useDefaultFilters = false)
@Import(value = {Red.class, MyImport.class})
@ComponentScan(value = "wxx.javaPra.anno")
@PropertySource(value = "man.properties")
public class PojoConfig {

    @Scope(value = "single")
    @Bean(value = "wxx",initMethod = "init", destroyMethod = "destroy")
    @Lazy
    @Value(value = "sdfx")
    public Person person(){
        return new Person("wangxu", 23);
    }

    @Bean
    @Conditional(WinCondition.class)
    public Person win(){
        return new Person("win",1);
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public Person linux(){
        return new Person("linux",1);
    }

    @Bean
    public YellowFac getYellow(){
        return new YellowFac();
    }
}
