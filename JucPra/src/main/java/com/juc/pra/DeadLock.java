package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-11:24
 **/
public class DeadLock {
    public static void main(String[] args) {
        String s1 = "lockA";
        String s2 = "lockB";
        //用两个锁分别锁住即可
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s1){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        System.out.println(Thread.currentThread().getName() + "正在运行");
                    }
                }
            }
        }, s1).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        System.out.println(Thread.currentThread().getName() + "正在运行");
                    }
                }
            }
        }, s2).start();
    }
}
