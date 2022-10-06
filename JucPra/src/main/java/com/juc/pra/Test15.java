package com.juc.pra;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.wxx
 * @create 2021-07-28-19:55
 **/
public class Test15 {
    public static void main(String[] args) {
        String str = new String("123");
        char[] c = new char[]{'a', 'b'};
        Test15 test15 = new Test15();
        test15.change(str, c);
        System.out.println(str);
        System.out.println(c[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map instanceof HashMap);
    }

    public void change(String str, char[] c){
        str = "456";
        c[0] = '1';
    }
}
