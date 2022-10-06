package com.juc.pra.basic;

import org.junit.Test;

/**
 * @author Mr.wxx
 * @create 2022-10-02-21:28
 **/
public class ThreadMethod {
    @Test
    public void testSetDaemon(){
        // 测试setDaemon()方法
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; ++i) {
                    try {
                        System.out.println(Thread.currentThread() + "的计数器：" + i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        // 设置当前线程为Daemon线程
        thread1.setDaemon(true);
    }

    @Test
    public void testIsAlive(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; ++i) {
                    try {
                        System.out.println(Thread.currentThread() + "的计数器：" + i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        if(thread1.isAlive()){
            try {
                Thread.sleep(500);
                System.out.println(thread1.getName() + "is alive");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
