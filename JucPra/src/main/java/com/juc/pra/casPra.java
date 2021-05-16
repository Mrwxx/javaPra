package com.juc.pra;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Mr.wxx
 * @create 2021-05-07-10:38
 **/
public class casPra {
    public static void main(String[] args) {

        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(1, 1);
        new Thread(()->{
            System.out.println("A ->" + integerAtomicStampedReference.getStamp());
            integerAtomicStampedReference.compareAndSet(1,2,integerAtomicStampedReference.getStamp(),integerAtomicStampedReference.getStamp()+1);
            System.out.println("A ->" + integerAtomicStampedReference.getStamp());
        }).start();

        new Thread(()->{
            System.out.println("B ->" + integerAtomicStampedReference.getStamp());
            integerAtomicStampedReference.compareAndSet(1,2,integerAtomicStampedReference.getStamp(),integerAtomicStampedReference.getStamp()+1);
            System.out.println("B ->" + integerAtomicStampedReference.getStamp());
        }).start();
    }
}
