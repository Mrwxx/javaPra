package com.juc.pra.twoThread100;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.wxx
 * @create 2021-08-04-17:10
 **/
public class twoThread100NoCondi {
    private static volatile int count = 1;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count <= 100){
                    if(count % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " 卖出了 " + count);
                        count++;
                    }
                }
            }
        }, "win1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count <= 100){
                    if(count % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + " 卖出了 " + count);
                        count++;
                    }
                }
            }
        }, "win2").start();

    }
}

