package com.juc.pra.threeABC;

import java.util.concurrent.Semaphore;

/**
 * @author Mr.wxx
 * @create 2021-08-04-16:13
 **/
public class threeABCSema {
    private static Semaphore sa = new Semaphore(1);
    private static Semaphore sb = new Semaphore(0);
    private static Semaphore sc = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; ++i){
                        sa.acquire();
                        System.out.println("A");
                        sb.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; ++i){
                        sb.acquire();
                        System.out.println("B");
                        sc.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; ++i){
                        sc.acquire();
                        System.out.println("C");
                        sa.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
