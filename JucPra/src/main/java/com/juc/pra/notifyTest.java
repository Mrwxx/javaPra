package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-14:12
 **/
public class notifyTest {
    public static void main(String[] args) {
        Commute commute = new Commute();
        new Thread(commute, "t1").start();
        new Thread(commute, "t2").start();
    }
}

class Commute implements Runnable{
    int i = 1;
    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            //用
            synchronized (this){
                this.notify();
                if(i <= 100){
                    System.out.println(Thread.currentThread().getName() + " : " + i++);
                }else{
                    break;
                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
