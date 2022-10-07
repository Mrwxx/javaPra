package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mr.wxx
 * @create 2021-06-22-10:14
 **/
public class DynamicPra {
    public static void main(String[] args) {
        //被代理对象
        Food myFood = new MyFood();
        //生成代理对象，注意需要强转为与被代理类对象同类型的接口
        Food dynamicProxyIns = (Food) ProxyFact.getDynamicProxyIns(myFood);
        // 通过代理类对象调用方法
        dynamicProxyIns.eat();
    }
}

interface Food{
    void eat();
}

class MyFood implements Food {
    @Override
    public void eat() {
        System.out.println("这是被代理类");
    }
}

//动态代理对象的工厂类
class ProxyFact{
    //专门获取动态代理对象
    public static Object getDynamicProxyIns(Object obj){
        //生成处理器对象
        Handler handler = new Handler(obj);
        //通过反射生成动态代理对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

/***
 * 动态代理调用处理器
 */
class Handler implements InvocationHandler {
    //传入被代理对象实例
    Object obj = null;
    //代理类的操作定义
    public Handler(Object obj){
        this.obj = obj;
    }

    /***
     * 调用处理器，即动态生成的代理对象在调用被代理类的同名方法时应该做哪些操作，是否需
     * 要通过反射来调用被代理类的同名方法，是否需要执行其他的操作等等，都是在这个类中的
     * invoke()方法中定义的。
     * @param proxy 代理类的对象
     * @param method 要调用的被代理对象的同名方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用被代理对象的方法，就需要传入被代理对象实例
        Object invoke = method.invoke(obj, args);
        System.out.println("这是动态代理对象");
        //调用的返回结果
        return invoke;
    }
}