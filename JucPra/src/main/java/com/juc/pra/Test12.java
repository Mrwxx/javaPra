package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-07-23-13:20
 **/
public class Test12 {
    public static void main(String[] args) {
        B b = new B();
        Object o = new Object();
        Object o1 = new Object();
        System.out.println(o.hashCode());
        System.out.println(o1.hashCode());
    }

}

class A{
    static int sa = saFunc();
    int a = aFunc();
    static{
        System.out.println("static代码块A");
    }
    static int saFunc(){
        System.out.println("static成员属性A");
        return 0;
    }
    int aFunc() {
        System.out.println("普通成员属性初始化A");
        return 0;
    }
    A(){
        System.out.println("构造函数调用A");
    }
}

class B extends A{
    static int sb = sbFunc();
    int b = bFunc();
    static{
        System.out.println("static代码块B");
    }
    static int sbFunc(){
        System.out.println("static成员属性B");
        return 0;
    }
    int bFunc(){
        System.out.println("普通成员属性B");
        return 0;
    }
    B(){
        System.out.println("构造函数调用B");
    }
}
