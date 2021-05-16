package com.boot.pojo;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Mr.wxx
 * @create 2021-04-27-14:31
 **/
@Data
//@Getter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
public class User {

    private int age;
    private String name;

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.remove(0);
    }

}

