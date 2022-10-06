package com.juc.pra;

import java.util.Collections;

/**
 * @author Mr.wxx
 * @create 2021-07-29-15:46
 **/
public class Test17 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.reverse().toString();
//        Collections.reverse();
        String s = "";
    }
}

/**

 * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) {

 *         val = x;

 *         next = null;

 *     }

 * }

 */

//public class Solution {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        //here
//        ListNode h1 = headA;
//        ListNode h2 = headB;
//        while(h1 != h2){
//            h1 = h1 == null ? headB : h1.next;
//            h2 = h2 == null ? headB : h2.next;
//        }
//        return h1;
//    }
//
//}
