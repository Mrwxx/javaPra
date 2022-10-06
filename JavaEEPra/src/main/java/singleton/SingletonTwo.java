package singleton;

/**
 * 懒汉式单例模式
 *     优点：延迟对象的创建
 *     缺点：线程安全问题
 *
 * @author Mr.wxx
 * @create 2022-10-01-20:05
 **/
public class SingletonTwo {
    private SingletonTwo(){

    }
    private static SingletonTwo single;
    public static SingletonTwo getInstance(){
        if(single == null){
            single = new SingletonTwo();
        }
        return single;
    }
}
