package io;

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(2).append(3).append(23);
        System.out.println(sb.toString());
        String s = new String();
//        s.substring()
        sb.length();
        new LinkedHashMap<>();
        new HashMap<>();
        Arrays.asList();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue;
        int n = 1;
        int i = n & 1;
//        Collections.copy(list1, list2);
        int[] ints = new int[3];
        Arrays.fill(ints, 1);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.remove(1);
        int[][] a = new int[][]{{1,2},{2,3}};
        Arrays.sort(a, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> ints1 = new ArrayList<>();
        int[][] ints2 = ints1.toArray(new int[ints1.size()][]);
    }

    public boolean isPowerOfTwo(int n) {
        // 从二进制的角度分析，它的所有位只有一个1
        int count = 0;
        while(n != 0){
            // 最后一位是1
            if((n & 1) != 0){
                count++;
            }
            n >>= 1;
        }
        return count == 1 ? true : false;

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.
    }
}
