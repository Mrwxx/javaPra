package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-07-17-23:30
 **/
public class Cp {
    public static void main(String[] args) {
        Ca ca = new Ca();
        Pro2 pro = new Pro2(ca);
        Con2 con = new Con2(ca);
        new Thread(pro, "pro").start();
        new Thread(con, "con").start();
    }
}

class Ca{
    //缓存区
    private static int pro = 0;

    //生产方法
    public void addPro(){
        //生产一个商品，有一个限制商品数，锁住
        synchronized (this){
            if(pro > 20){
                //停止
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                //继续生产
                System.out.println(Thread.currentThread().getName() + "生产了 1个，还剩下 " + pro++);
                this.notifyAll();
            }
        }
    }

    //消费方法
    public void conPro(){
        //消费商品，没有商品就需要限制消费
        //wait, notify需要在同步代码块中
        synchronized (this){
            if(pro <= 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + "消费了 1个， 还剩下" + pro--);
                this.notifyAll();
            }
        }
    }
}

//生产者
class Pro2 implements Runnable{
    private Ca ca;
    public Pro2(Ca ca){
        this.ca = ca;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                ca.addPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Con2 implements Runnable{
    private Ca ca;
    public Con2(Ca ca){
        this.ca = ca;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(300);
                ca.conPro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}





