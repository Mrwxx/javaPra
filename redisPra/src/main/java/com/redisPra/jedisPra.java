package com.redisPra;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Mr.wxx
 * @create 2021-04-22-10:34
 **/
public class jedisPra {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.112.130", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
        LinkedList<Integer> list = new LinkedList<Integer>();

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
    }


}
