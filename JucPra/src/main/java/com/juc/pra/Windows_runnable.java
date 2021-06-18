package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-9:12
 **/
public class Windows_runnable {
    public static void main(String[] args) {
        Windows2 windows2 = new Windows2();
        Thread thread1 = new Thread(windows2, "窗口1");
        Thread thread2 = new Thread(windows2, "窗口2");
        Thread thread3 = new Thread(windows2, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Windows2 implements Runnable{
    //不需要加static，因为只有一个Runnable对象
    private int num = 100;
    @Override
    public void run() {
        while(true){
            synchronized (Windows2.class){
                if(num > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "： 卖票，票号为：" + num--);
                }else{
                    break;
                }
            }
        }
    }
}
