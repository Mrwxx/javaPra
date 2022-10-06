package com.juc.pra.threeABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.wxx
 * @create 2021-08-04-16:03
 **/
public class threeABCCon {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conA = lock.newCondition();
    private static Condition conB = lock.newCondition();
    private static Condition conC = lock.newCondition();
    private static int count = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i){
                    try {
                        lock.lock();
                        while(count % 3 != 0){
                            conA.await();
                        }
                        System.out.println("A");
                        count++;
                        conB.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i){
                    try {
                        lock.lock();
                        while(count % 3 != 1){
                            conB.await();
                        }
                        System.out.println("B");
                        count++;
                        conC.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; ++i){
                    try {
                        lock.lock();
                        while(count % 3 != 2){
                            conC.await();
                        }
                        System.out.println("C");
                        count++;
                        conA.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
    }
}
