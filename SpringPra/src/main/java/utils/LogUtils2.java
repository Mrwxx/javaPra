package utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**切面类
 * @author Mr.wxx
 * @create 2021-04-11-8:52
 **/
@Aspect
@Component
public class LogUtils2 {
    @Before("execution(public int inter.impl.MyCalculator.*(int, int))")
    public static void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("方法 " + name + " 的Before通知开始执行，参数是："+ Arrays.asList(args));
    }

    @After("execution(public int inter.impl.MyCalculator.*(int, int))")
    public static void logEnd(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("方法" + name +  " After通知开始执行，参数是：" + Arrays.asList(args));
    }

    @AfterThrowing("execution(public int inter.impl.MyCalculator.*(int, int))")
    public static void logExceptiion(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("方法" + name + " AfterThrowing开始执行，参数是：" + Arrays.asList(args)) ;
    }

    @AfterReturning("execution(public int inter.impl.MyCalculator.*(int, int))")
    public static void logReturning(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("方法"+ name + " AfterThrowing开始执行，参数是：" + Arrays.asList(args));
    }
}
