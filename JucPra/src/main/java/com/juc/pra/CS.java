package com.juc.pra;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Mr.wxx
 * @create 2021-08-04-17:41
 **/
public class CS {
    public static void main(String[] args) {
        ProCache proCache = new ProCache();
        new Thread(new Consu(proCache), "consumer").start();
//        for(int i = 0; i < 10; ++i){
//            new Thread(new Pro(proCache), "producer"+i).start();
//        }
        //使用线程池
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; ++i){
            pool.execute(new Pro(proCache));
        }
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}

class ProCache{
    //商品池
    private static int pro = 0;

    //取商品
    synchronized void takePro(){
        //没有商品则不能取
        if(pro <= 0){
            //通知生产者
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            pro--;
            System.out.println(Thread.currentThread().getName() + "消费者拿走了一个商品，还剩 " + pro + "件商品");
        }
        //通知消费者
        this.notifyAll();
    }

    //放入商品
    synchronized void addPro(){
        if(pro >= 20){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            pro++;
            System.out.println(Thread.currentThread().getName() + "生产者生产了一件商品，还剩 " + pro +  " 件商品");
        }
        //通知消费者
        this.notifyAll();
    }
}

//生产者
class Pro implements Runnable{
    ProCache cache;
    //调用Cache中的方法
    public Pro(ProCache cache){
        this.cache = cache;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用生产商品
            cache.addPro();
        }
    }
}

//生产者
class  Consu implements Runnable{
    ProCache cache;
    //调用Cache中的方法
    public Consu(ProCache cache){
        this.cache = cache;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用生产商品
            cache.takePro();
        }
    }
}