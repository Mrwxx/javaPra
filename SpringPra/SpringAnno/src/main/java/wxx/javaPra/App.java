package wxx.javaPra;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
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
        AnnotationConfigApplicationContext acc = new AnnotationConfigApplicationContext();
    }
}
