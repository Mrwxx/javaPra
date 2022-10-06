package singleton;

/**
 * 饿汉式单例模式
 *     优点：线程安全的
 *     缺点：对象加载时间长
 *
 * @author Mr.wxx
 * @create 2022-10-01-19:59
 **/
public class SingletonOne {
    // 私有的构造函数
    private SingletonOne(){
    }
    // 内部的static实例
    private static SingletonOne single = new SingletonOne();
    // 提供对外的方法，不能通过对象访问，只能通过static方法获取
    public static SingletonOne getInstance(){
        return single;
    }
}
