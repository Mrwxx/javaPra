package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-9:42
 **/
public class Windows_volatile {
    public static volatile int num = 10000;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(num > 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "： 卖票,票号为： " + num--);
                    }else{
                        break;
                    }
                }
            }
        }, "窗口1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(num > 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "： 卖票,票号为： " + num--);
                    }else{
                        break;
                    }
                }
            }
        }, "窗口2");
        thread1.start();
        thread2.start();
    }


}
