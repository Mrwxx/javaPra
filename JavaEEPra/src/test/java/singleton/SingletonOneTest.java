package singleton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.wxx
 * @create 2022-10-01-20:15
 **/
public class SingletonOneTest {

    @Test
    public void testGetInstance() {
        SingletonOne instance1 = SingletonOne.getInstance();
        SingletonOne instance2 = SingletonOne.getInstance();
        System.out.println("单例是否生效：" + (instance1==instance2));
        Assert.assertEquals((instance1 == instance2), true);
    }
}