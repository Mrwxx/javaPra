package stringClass;

import org.junit.Assert;
import org.junit.Test;

/**
 * String的matches方法，基于正则表达式
 * @author Mr.wxx
 * @create 2022-10-03-11:49
 **/
public class StringMatch {

    @Test
    public void matchAllDigits(){
        // 判断字符串中是否全部由数字组成
        String str = "12345";
        boolean digitsMatches = str.matches("\\d+");
        Assert.assertEquals(digitsMatches, true);
    }

    @Test
    public void matchPhoneNum(){
        // 判断是否是0571固定电话
        String tel = "0571-1231145";
        boolean isTel = tel.matches("0571-\\d{7,8}");
        Assert.assertEquals(isTel, true);
    }
}
