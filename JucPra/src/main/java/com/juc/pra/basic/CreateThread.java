package com.juc.pra.basic;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 基本的多线程方式
 *
 * @author Mr.wxx
 * @create 2022-10-02-20:23
 **/
public class CreateThread{
    public static int count = 0;
    public static void main(String[] args) {

    }

    @Test
    public void testExtendThread(){
        // 1.继承Thread创建
        new MyThread().start();
        new MyThread().start();
    }

    @Test
    public void testImpleRunnable(){
        // 2.实现Runnable接口
        new Thread(new MyThread2()).start();
        new Thread(new MyThread2()).start();
    }

    @Test
    public void testImpleCallable(){
        // 3.实现Callable接口
        FutureTask<String> stringFutureTask = new FutureTask<String>(new MyThread3());
        new Thread(stringFutureTask, "callable方法").start();
        try {
            String s = stringFutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
        }
    }

}

class MyThread extends Thread{
    public MyThread(){
        super();
    }

    @Override
    public void run() {
        synchronized (MyThread.class){
            while(true){
                try {
                    MyThread.class.notify();
                    if(CreateThread.count <= 100){
                        System.out.println("子线程" + Thread.currentThread() + "持续计数：" + CreateThread.count++);
                        MyThread.class.wait();
                    }else{
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        synchronized (MyThread2.class){
            while(true){
                try {
                    MyThread2.class.notify();
                    if(CreateThread.count <= 100){
                        System.out.println("子线程" + Thread.currentThread() + "持续计数：" + CreateThread.count++);
                        MyThread2.class.wait();
                    }else{
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }
}

class MyThread3 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable方法创建线程");
        return String.valueOf(123);
    }
}
