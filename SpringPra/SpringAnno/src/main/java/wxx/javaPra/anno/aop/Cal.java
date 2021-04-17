package wxx.javaPra.anno.aop;

import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-04-17-16:18
 **/
@Component
public class Cal {

    public int add(int a, int b){
        System.out.println("方法执行");
        return a+b;
    }
}
