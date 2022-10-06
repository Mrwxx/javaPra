package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-08-03-19:30
 **/
public interface a {
    int add();
    default int add2(){
        return 0;
    }

}
