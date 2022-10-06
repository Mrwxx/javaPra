package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-07-17-22:14
 **/
public class Jiaoti {
    public static void main(String[] args) {
        Compute compute = new Compute();
        new Thread(compute, "窗口1").start();
        new Thread(compute, "窗口2").start();
    }
}

class Compute implements Runnable{
    private static int i = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this){
                this.notify();
                if(i <= 100){
                    System.out.println(Thread.currentThread().getName() + " 输出 " + i++);
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