package com.juc.pra;

import java.util.LinkedList;

/**
 * @author Mr.wxx
 * @create 2021-07-23-0:39
 **/
public class Test11 {
    public static void main(String[] args) {
        calculate("3+2*2");
    }

    public static int calculate(String s) {
        // x,/的优先级一定比+,-高，则只有在遇到x,/时才会出栈
        //注意，初始的默认符号为+，每个数字后面的符号对应后面的数字
        int n = s.length();
        char[] str = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        //数字直接入栈，+-将后续数字按照正负号入栈，只有遇到*,/才会出栈
        int num = 0;
        //符号，默认符号为+
        char preSign = '+';
        for(int i = 0; i < n; ++i){
            char tmp = str[i];
            if(tmp == ' '){
                continue;
            }
            //数字，则需要组成一个长的数字
            if(tmp >= '0' && tmp <= '9'){
                num = 10 * num + (tmp-'0');
            }
            //存在一个问题，最后一个数字没有进行计算啊，因此在最后一个位置n-1进行强制计算
            if(!Character.isDigit(tmp) || i == n-1){
                //是字符，根据字符情况对后续数字入栈
                switch(preSign){
                    //正号，+num入栈
                    case '+':
                        stack.offerLast(num);
                        break;
                    //负号，-num入栈
                    case '-':
                        stack.offerLast(-1 * num);
                        break;
                    //乘积，则栈中弹出数字相乘再入栈
                    case '*':
                        stack.offerLast(stack.pollLast() * num);
                        break;
                    //除号
                    case '/':
                        stack.offerLast(stack.pollLast() / num);
                }
                //修改preSign为新的字符
                preSign = tmp;
                //更新num
                num = 0;
            }
        }
        return stack.pollLast();
    }

}
