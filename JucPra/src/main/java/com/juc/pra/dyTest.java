package com.juc.pra;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Mr.wxx
 * @create 2021-07-19-20:12
 **/
public class dyTest {
    public static void main(String[] args) {
        Real real = new Real();
        Server proxy = (Server)ProxyFac.getProxy(real);
        proxy.sign();
    }
}

interface Server{
    public void sign();
}

class Real implements Server{

    @Override
    public void sign() {
        System.out.println("this is the real server");
    }
}

class ProxyFac{
    public static Object getProxy(Object obj){
        Handler handler = new Handler(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        return o;
    }
}

class Handler implements InvocationHandler{
    Object real = null;
    //构造函数
    public Handler(Object real){
        this.real = real;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(real, null);
        System.out.println("this is the proxy server");
        return invoke;
    }
}
