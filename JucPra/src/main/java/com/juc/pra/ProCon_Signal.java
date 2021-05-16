package com.juc.pra;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.wxx
 * @create 2021-05-02-21:46
 **/
public class ProCon_Signal {
    public static void main(String[] args) {
        Doct doct = new Doct();
        Producer producer = new Producer(doct);
        Consume consume = new Consume(doct);
        producer.start();
        consume.start();
    }
}

//生产者
class Producer extends Thread{
    //产品属性
    Doct doct = null;
    Producer(Doct doct){
        this.doct = doct;
    }
    //生产逻辑

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            doct.push();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer[] num = new Integer[10];
            Arrays.sort(num, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return 0;
                }

            });

        }
    }
}

//消费者
class Consume extends Thread{
    //产品属性
    Doct doct = null;
    Consume(Doct doct){
        this.doct = doct;
    }
    //消费逻辑
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            doct.pop();
        }
    }
}

//产品
class Doct{
    //标志
    // true, 则开始消费，通知生产者生产
    // false,则开始生产，通知消费者消费
    static boolean flag = false;

    //消费产品
    public synchronized void pop(){
        if(!flag){
            //flag为false，则消费等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费产品了");
        //通知生产者
        this.notifyAll();
        flag = !flag;
    }

    //生产产品
    public synchronized void push(){
        if(flag){
            //flag为true，则生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产产品了");
        //通知消费者
        this.notifyAll();
        flag = !flag;
    }
}
