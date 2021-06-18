package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-14:45
 **/
public class Pro_Sale {
    public static void main(String[] args){
        Clerk clerk = new Clerk();
        Producer2 producer2 = new Producer2(clerk);
        Consumer2 consumer2 = new Consumer2(clerk);
        new Thread(producer2, "pro").start();
        new Thread(consumer2, "con").start();
    }
}

class Clerk{
    private int product = 0;

    //添加商品
    public synchronized void addPro(){
        //限定超过20件停止添加
        if(product >= 20){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产者生产了第 " + product + "件商品");
            this.notifyAll();
        }
    }

    //拿走商品
    public synchronized void takePro(){
        //没有商品了，则停止
        if(product <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product--;
            System.out.println("消费者拿走了第 " + product + "件商品" );
            //通知消费者
            this.notifyAll();
        }
    }
}

//生产者
class Producer2 implements Runnable{
    private Clerk clerk;
    //调用Clerk中的方法
    public Producer2(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //添加商品
            clerk.addPro();
        }
    }
}

class Consumer2 implements Runnable{
    private Clerk clerk;

    public Consumer2(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("消费者开始消费");
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //拿走商品
            clerk.takePro();
        }
    }
}