package com.juc.pra.singleton;

/**
 * 懒汉式单例（调用时才创建实例）
 * @author Mr.wxx
 * @create 2021-07-17-22:12
 **/
public class Sing2 {
    private Sing2(){}
    private static volatile Sing2 sing2 = null;
    public static Sing2 getSing2(){
        // 线程安全的double check
        if(sing2 == null){
            synchronized (sing2){
                if(sing2 == null){
                    sing2 = new Sing2();
                }
            }
        }
        return sing2;
    }
}
