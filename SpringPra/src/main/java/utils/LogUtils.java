package utils;

import java.lang.reflect.Method;

/**切面类
 * @author Mr.wxx
 * @create 2021-04-11-8:52
 **/
public class LogUtils {
    public static void logStart(Method method, Object...args){
        System.out.println("方法" + method.getName() + " 开始执行，参数是："+ args.toString());
    }

    public static void logEnd(Method method, Object...args){
        System.out.println("方法" + method.getName() + " 开始执行，参数是："+ args.toString());
    }

    public static void logExceptiion(Method method, Object...args){
        System.out.println("方法" + method.getName() + " 开始执行，参数是："+ args.toString());
    }
}
