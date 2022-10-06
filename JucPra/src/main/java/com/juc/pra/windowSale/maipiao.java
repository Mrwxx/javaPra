package com.juc.pra.windowSale;

/**
 * @author Mr.wxx
 * @create 2021-07-17-21:51
 *
 * 卖票问题
 **/
public class maipiao {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(tickets, "窗口1").start();
        new Thread(tickets, "窗口2").start();
    }
}

class Tickets implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while(true){
            synchronized (Tickets.class){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 还有 " + ticket-- + "张票");
                }else{
                    break;
                }
            }
        }
    }
}
