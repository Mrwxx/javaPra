package com.juc.pra.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Mr.wxx
 * @create 2021-06-18-10:47
 **/
public class SingleLazyJuc {
    public static void main(String[] args) {
        Single2 s1 = null;
        Single2 s2 = null;
        FutureTask<Single2> t1 = new FutureTask<>(new Callable<Single2>() {
            @Override
            public Single2 call() throws Exception {
                return Single2.getSingle2();
            }
        });
        FutureTask<Single2> t2 = new FutureTask<>(new Callable<Single2>() {
            @Override
            public Single2 call() throws Exception {
                return Single2.getSingle2();
            }
        });
        Thread thread1 = new Thread(t1,"线程1");
        Thread thread2 = new Thread(t2,"线程2");
        thread1.start();
        thread2.start();
        try {
            s1 = t1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            s2 = t2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s1 == s2);
    }
}

class Single2{
    private Single2(){
    }
    private static volatile Single2 single2 = null;
    public static Single2 getSingle2(){
        if(single2 == null){
            synchronized (Single2.class){
                if(single2 == null){
                    single2 = new Single2();
                }
            }

        }
        return single2;
    }
}

class Run implements Runnable{

    private Single2 single2 = null;
    @Override
    public void run() {
        single2 =  Single2.getSingle2();
    }

    public Single2 getSingle2(){
        return single2;
    }
}