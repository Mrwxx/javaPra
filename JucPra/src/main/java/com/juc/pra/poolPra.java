package com.juc.pra;

import java.util.concurrent.*;

/**
 * @author Mr.wxx
 * @create 2021-05-06-8:45
 **/
public class poolPra {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            // 使用线程池执行线程
//            scheduledExecutorService.execute(
//                    ()->{
//                        System.out.println(Thread.currentThread().getName());
//                    });
//
//        }

        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 0; i < 20; i++) {
                threadPoolExecutor.execute(
                        ()->{
                            System.out.println(Thread.currentThread().getName());
                        }
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
