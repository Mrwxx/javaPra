package proxy;

import inter.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mr.wxx
 * @create 2021-04-10-22:41
 **/
public class CalculatorProxy {

    /***
     * 为传入的对象创建动态代理对象
     * @return
     */
    public static Calculator getProxy(final Calculator calculator){

        // 对象的类加载器
        ClassLoader loader = calculator.getClass().getClassLoader();
        // 对象实现的接口
        Class<?>[] inter = calculator.getClass().getInterfaces();
        // 方法执行器，帮目标对象执行目标方法
        InvocationHandler handler = new InvocationHandler() {
            /***
             *
             * @param proxy 代理对象，供JDK使用，不要动
             * @param method 目标对象要执行的方法
             * @param args  目标对象要执行的方法需要传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 动态代理新增的处理
                System.out.println("动态代理方法执行前的处理！");
                // 通过反射执行目标方法
                Object result = method.invoke(calculator, args);
                System.out.println("动态代理方法执行后的处理！");
                return result;
            }
        };
        Calculator proxy = (Calculator) Proxy.newProxyInstance(loader, inter, handler);
        return proxy;
    }
}
