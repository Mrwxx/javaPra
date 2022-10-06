package com.juc.pra.threeABC;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Mr.wxx
 * @create 2021-08-04-15:20
 **/
public class threeABC {
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10;) {
                    try {
                        lock.lock();
                        while (state % 3 == 0) {
                            System.out.println("A" + i);
                            state++;
                            i++;
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state % 3 == 1) {
                            System.out.println("B" + i);
                            state++;
                            i++;
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ) {
                    try {
                        lock.lock();
                        while (state % 3 == 2) {
                            System.out.println("C" + i);
                            state++;
                            i++;
                        }
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }

    private static ReentrantLock lock = new ReentrantLock();
    private static int state = 0;

}
