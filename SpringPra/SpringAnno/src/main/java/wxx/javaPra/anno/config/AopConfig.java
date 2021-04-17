package wxx.javaPra.anno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import wxx.javaPra.anno.aop.Cal;
import wxx.javaPra.anno.aop.CalAspect;

/**
 * @author Mr.wxx
 * @create 2021-04-17-16:17
 **/
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public Cal getCal(){
        return new Cal();
    }

    @Bean
    public CalAspect getCalAspect(){
        return new CalAspect();
    }
}
