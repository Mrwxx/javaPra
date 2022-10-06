package com.juc.pra.singleton;

/**
 * 饿汉式单例
 * @author Mr.wxx
 * @create 2021-07-17-22:11
 **/
public class Sing {
    private Sing(){
    }
    private static Sing sing = new Sing();
    public static Sing getSing(){
        return sing;
    }
}
