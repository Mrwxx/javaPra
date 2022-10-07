package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.zip.ZipOutputStream;

public class test2 {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        DataInputStream inputStream = new DataInputStream(new FileInputStream("a.txt"));
        int i = inputStream.readInt();
//        DataInput dataInput = new DataInput();

//        var fout = new FileOutputStream("test.zip");
//        var zout = new ZipOutputStream(fout);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.remove(0);
        Integer[] integers1 = integers.toArray(new Integer[integers.size()]);
        ArrayList<Integer> integers2 = new ArrayList<>(integers);
        integers.remove(0);

        MessageDigest alg = MessageDigest.getInstance("SHA-1");
        String s = String.valueOf(integers);
        Integer[] integers3 = integers.toArray(new Integer[integers.size()]);
        integers.forEach( a -> {
            new StringBuffer().append(a);
        });

        PriorityQueue<Integer> integers4 = new PriorityQueue<>();
//        integers4
        String s1 = "11";
        String s2 = "11";
        int i1 = s1.compareTo(s2);
        HashMap<String, Integer> map = new HashMap<>();
//        map.getOrDefault()

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            //Set<Map.Entry<String, Integer>> entries = map.entrySet();
            e.getValue();
            e.getKey();
        }

//        new Queue<>()
        LinkedList<Integer> integers5 = new LinkedList<>();
//        integers5.poll();
//        integers5.pollLast();
//        integers4.remove(a);
//        Stack<Object> objects = new Stack<>();
        LinkedList<Integer> integers6 = new LinkedList<>();
        integers6.offer(1);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1).append(2).append(3);
        System.out.println(stringBuffer);
        String s3 = new String("111");
//        String strip = s3.strip();
//        s3.substring()
    }
}
