package singleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author Mr.wxx
 * @create 2022-10-01-20:11
 **/
public class SingletonTwoTest {

    @Test
    public void testGetInstance() {
        SingletonTwo instance1 = SingletonTwo.getInstance();
        SingletonTwo instance2 = SingletonTwo.getInstance();
        System.out.println("单例是否生效：" + (instance1==instance2));
        Assert.assertEquals((instance1 == instance2), true);
    }
}
