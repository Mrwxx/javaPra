package com.juc.pra;

/**
 * @author Mr.wxx
 * @create 2021-07-20-16:10
 **/
public class Test10 {
    public static void main(String[] args) {
        String s = new String("1+2-10");
        int ans = compute(s);
        System.out.println(ans);
    }

    public static int compute(String str){
        //分割数字和符号
        int i = 0;
        int sum = 0;
        int cur =  1;
        int curNum = 0;
        while(i < str.length()){
            if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                if(str.charAt(i) == '-'){
                    cur = -1;
                }
                ++i;
            }else{
                StringBuffer ss = new StringBuffer();
                //数字解析
                while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    ss.append(str.charAt(i));
                    i++;
                }
                curNum = Integer.parseInt(ss.toString());
                sum += cur * curNum;
            }
        }
        return sum;
    }
}
