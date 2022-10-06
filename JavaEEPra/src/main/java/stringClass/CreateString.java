package stringClass;

import org.junit.Assert;
import org.junit.Test;

/**
 * 构造String对象
 * @author Mr.wxx
 * @create 2022-10-03-12:29
 **/
public class CreateString {

    @Test
    public void charToString(){
        char c = 'a';
        String s = String.valueOf(c);
    }

    @Test
    public void charArrayToString(){
        // char数组转String

        char[] charArr = new char[]{'a', 'b'};
        String s = new String(charArr);
        Assert.assertEquals(s, "ab");
    }

    @Test
    public void intToString(){
        int a = 123;
        // String的valueOf方法
        String s = String.valueOf(a);
        // Integer的toString方法
        String s1 = Integer.toString(a);
    }


}
