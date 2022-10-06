package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mr.wxx
 * @create 2021-03-27-15:50
 **/
public class DynamicProxy {
    public static void main(String[] args) {
        // 被代理类
        SuperMan superMan = new SuperMan();
        // 生成代理类
        Human proxyInstance = (Human) ProxyFac.getProxyInstance(superMan);
        //通过代理类调用被代理类同名方法
        System.out.println(proxyInstance.get());
        proxyInstance.eat("egg");
    }
}

interface Human{
    String get();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String get() {
        return "wxx";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃什么" + food);
    }
}

class ProxyFac{

    //调用该方法，返回一个代理类对象, obj是被代理类对象
    public static Object getProxyInstance(Object obj){
        // 新建一个自定义调用处理类
        MyInvocationHandler handler =  new MyInvocationHandler();
        // 将被代理类赋值到处理类中
        handler.setObj(obj);
        /// 产生一个代理类对象，参数为obj的类加载器，obj实现的接口，以及调用处理类
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    // 被代理类对象
    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    // 当我们调用代理类的对象的方法时，就会调用下面的invoke()方法
    // 由于代理类需要调用被代理类的同名方法，因此需要在invoke()中调用被代理类的同名方法，使用反射实现
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy是代理类对象，method是要调用的同名方法，args是方法的参数
        // 如果需要调用被代理类对象，需要传进来
        Object invoke = method.invoke(obj, args);
        System.out.println("这是动态代理对象");
        //invoke是方法的执行结果
        return invoke;
    }

}
