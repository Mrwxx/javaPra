package stringClass;

import org.junit.Assert;
import org.junit.Test;

/**
 * replace方法的使用，基于正则表达式
 * @author Mr.wxx
 * @create 2022-10-03-11:58
 **/
public class StringReplace {

    @Test
    public void replaceAllDigits(){
        String str = "123ABC456";
        // 将所有数字都替换成""，即删除所有数字
        // 使用正则表达式
        String repStr = str.replaceAll("\\d+", "");
        Assert.assertEquals(repStr, "ABC");
    }

    @Test
    public void replaceDigit(){
        String str = "111ABC";
        // 替换数字1为2
        String repStr = str.replace("1", "2");
        Assert.assertEquals(repStr, "222ABC");
    }

}
