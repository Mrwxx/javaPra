package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-06-18-10:26
 **/
public class singleton_hungry {
    public static void main(String[] args) {
        Single.getSingle();
    }
}

class Single{
    int num;
    private Single(){
        num = 1;
    }
    private static Single single = new Single();
    public static Single getSingle(){
        return single;
    }
}
