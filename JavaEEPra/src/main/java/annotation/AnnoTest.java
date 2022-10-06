package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mr.wxx
 * @create 2021-06-19-14:25
 **/
@MyAnno(value = "bbb")
public class AnnoTest {
    public static void main(String[] args) {
        Class<AnnoTest> annoTestClass = AnnoTest.class;
        MyAnno annotation = annoTestClass.getAnnotation(MyAnno.class);
        String value = annotation.value();
        String second = annotation.second();
        System.out.println(AnnoTest.class.getName() + "的注解MyAnno的value值：" + value);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyAnno{
    String value() default "abc";

    String second() default "second";
}
