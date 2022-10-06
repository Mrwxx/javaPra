package com.juc.pra.windowSale;

/**
 * @author Mr.wxx
 * @create 2021-06-18-8:42
 **/
public class ThreadTest {
    public static void main(String[] args) {
        //多线程卖票
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket implements Runnable{

    private static int num = 100;
    @Override
    public void run() {
        while(true){
            //锁为this，Runnable对象
            synchronized (this){
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出 " + num--);
                }else{
                    break;
                }
            }
        }

    }
}
