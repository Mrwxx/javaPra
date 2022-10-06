package com.juc.pra.twoThread100;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.wxx
 * @create 2021-08-04-16:53
 **/
public class
twoThread100Reet {

    private static Lock lock = new ReentrantLock();
    private static Condition conA = lock.newCondition();
    private static Condition conB = lock.newCondition();
    private static int count = 1;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < 100) {
                    try {
                        lock.lock();
                        while (count % 2 != 1) {
                            conA.await();
                        }
                        System.out.println(Thread.currentThread().getName() + " 卖出了 " + count);
                        count++;
                        conB.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }, "win1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count < 100) {
                    try {
                        lock.lock();
                        while (count % 2 != 0) {
                            conB.await();
                        }
                        System.out.println(Thread.currentThread().getName() + " 卖出了 " + count);
                        count++;
                        conA.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }, "win2").start();

    }
}

