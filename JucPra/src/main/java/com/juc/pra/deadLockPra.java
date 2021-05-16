package com.juc.pra;

import java.util.concurrent.TimeUnit;

/**
 * @author Mr.wxx
 * @create 2021-05-07-13:40
 **/
public class deadLockPra {
    public static void main(String[] args) {
        String thread1 = "lockA";
        String thread2 = "lockB";
        new Thread(new deadLock(thread1, thread2), "T1").start();
        new Thread(new deadLock(thread2, thread1), "T2").start();
    }
}

class deadLock implements Runnable{
    private String lockA;
    private String lockB;

    public deadLock(String lockA, String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "正在执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "正在执行");
            }
        }
    }
}
