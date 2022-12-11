package wxx.javaPra.anno.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-04-17-16:18
 **/
@Component
public class Cal {

    @Autowired
    private Cal cal;

    public int add(int a, int b){
        System.out.println("方法执行");
        cal.addAnother(a+b, b);
        return a+b;
    }

    public int addAnother(int input, int c){
        return input + c;
    }

    public static void main(String[] args) {
        Cal cal = new Cal();
        cal.add(1,2);
    }
}
