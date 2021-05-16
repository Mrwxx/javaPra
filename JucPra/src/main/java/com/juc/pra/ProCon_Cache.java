package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-05-02-21:08
 **/
public class ProCon_Cache {
    public static void main(String[] args) {
        Cache cache = new Cache();
        Produce produce = new Produce(cache);
        Consumer consumer = new Consumer(cache);
        produce.start();
        consumer.start();
    }

}

//生产者
class Produce extends Thread{
    //缓冲区属性
    Cache cache = null;
    Produce(Cache cache){
        this.cache = cache;
    }

    //生产方法
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了" + (i+1) + "件商品");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cache.push(new Production());
        }
    }
}
//消费者
class Consumer extends Thread{
    //缓冲区属性
    Cache cache = null;
    Consumer(Cache cache) {
        this.cache = cache;
    }

    //消费方法
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了" + (i+1) + "件商品");
            cache.pop();
        }
    }
}
//产品
class Production{

}
//缓冲区
class Cache{
    //缓冲区的容量
    Production[] list = new Production[10];
    static int count = 0;

    //向缓冲区生产商品，即生产商品
    public synchronized void push(Production production){
        //如果缓冲区中容量满了
        if(count == list.length){
            //生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果缓冲区中容量没有满，生产继续
        list[count++] = production;
        //通知消费
        this.notifyAll();
    }

    //从缓冲区中取出商品，即消费商品
    public synchronized  void pop(){
        //如果缓冲区中容量为0
        if(count == 0){
            //消费等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果缓冲区中还有商品，可以继续消费
        count--;
        //通知生产
        this.notifyAll();
    }
}