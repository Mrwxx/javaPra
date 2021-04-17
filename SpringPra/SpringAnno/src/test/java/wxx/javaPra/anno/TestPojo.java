package wxx.javaPra.anno;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wxx.javaPra.anno.aop.Cal;
import wxx.javaPra.anno.config.AopConfig;
import wxx.javaPra.anno.config.PojoConfig;
import wxx.javaPra.anno.controller.PersonController;
import wxx.javaPra.anno.pojo.Man;
import wxx.javaPra.anno.pojo.Person;

/**
 * @author Mr.wxx
 * @create 2021-04-17-8:29
 **/
public class TestPojo {
    @Test
    public void test(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PojoConfig.class);
//        Person person = ioc.getBean(Person.class);
//        System.out.println(person.toString());
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        ioc.close();
    }

    @Test
    public void test2(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PojoConfig.class);
        Man bean = ioc.getBean(Man.class);
        System.out.println(bean);
        PersonController bean1 = ioc.getBean(PersonController.class);
        System.out.println(bean1);
    }

    @Test
    public void test3(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(PojoConfig.class);
        ioc.getEnvironment().addActiveProfile("test");
        ioc.register(PojoConfig.class);
        ioc.refresh();
    }

    @Test
    public void testAOP(){
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AopConfig.class);
        Cal cal = ioc.getBean(Cal.class);
        System.out.println(cal.getClass());
        int add = cal.add(1, 2);
    }

    @Test
    public void TestFactory(){

    }
}
