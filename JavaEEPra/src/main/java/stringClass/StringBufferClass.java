package stringClass;

import org.junit.Test;

/**
 * @author Mr.wxx
 * @create 2022-10-03-15:06
 **/
public class StringBufferClass {

    @Test
    public void testAppend(){
        StringBuffer stringBuffer = new StringBuffer("123");
        stringBuffer.append(123);
    }


}
