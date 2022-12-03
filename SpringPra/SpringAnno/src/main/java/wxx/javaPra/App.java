package wxx.javaPra;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import wxx.javaPra.anno.aop.Cal;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "wxx.javaPra.anno")
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        // 注解方式获取IOC容器
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext();
        // XML方式获取IOC容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        // FS方式获取IOC容器
        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext();
        // refresh()和close()让ApplicationContext具有启动、关闭和刷新上下文的能力
//        ConfigurableApplicationContext configurableApplicationContext = new ConfigurableApplicationContext();


    }
}
