package wxx.javaPra.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Mr.wxx
 * @create 2021-04-17-16:18
 **/
@Aspect
@Component
@EnableAspectJAutoProxy
public class CalAspect {

    @Pointcut(value = "execution(public * wxx.javaPra.anno.aop.Cal.*(..))")
    public void pointCut(){
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + " 方法执行前执行，参数是： " + Arrays.asList(args));
    }

    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + " 方法执行结束后执行，参数是： " + Arrays.asList(args));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + " 方法正常返回后执行，参数是： " + Arrays.asList(args) + " 结果是：" + result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception){
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + " 方法异常返回后执行，参数是： " + Arrays.asList(args) + " 异常是：" + exception);
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){

        System.out.println(" Around前执行");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
            System.out.println(" Around后执行");
        } catch (Throwable throwable) {
            System.out.println(" Around异常执行");
            throwable.printStackTrace();
        }
        return proceed;
    }
}
