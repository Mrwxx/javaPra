package com.juc.pra.twoThread100;

/**
 * @author Mr.wxx
 * @create 2021-08-04-16:47
 **/
public class towThread100 {
    public static void main(String[] args) {
        //wait-notify机制
        th th = new th();
        Thread w1 = new Thread(th, "w1");
        Thread w2 = new Thread(th, "w2");
        w1.start();
        w2.start();
    }


}

class th implements Runnable{
    private int i = 1;
    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                obj.notify();
                if(i <= 100){
                    System.out.println(Thread.currentThread().getName() + " 卖了 " + i);
                    i++;
                }else{
                    break;
                }
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
