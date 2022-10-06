package oop.test;

import oop.Base;
import oop.Sub;
import oop.SubSub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

/**
 * @author Mr.wxx
 * @create 2022-10-01-1:36
 **/
public class OopTest {
    private Base baseObj_1;
    private Base baseObj_2;
    private Sub subObj_1;
    private SubSub subSubObj_1;
    /***
     * 测试类的资源初始化
     */
    @Before
    public void init(){
        baseObj_1 = new Base();
        baseObj_2 = new Sub();
        subObj_1 = new Sub();
        subSubObj_1 = new SubSub();
        Integer integer = new Integer(1);

        System.out.println( OopTest.class.getName() +  "测试类资源初始化");
    }

    /***
     * 测试类的资源关闭
     */
    @After
    public void close(){
        System.out.println( OopTest.class.getName() +  "测试类资源关闭");
    }

    /***
     * 检查子类继承父类的public属性关系
     */
    @Test
    public void checkExtendField(){
        // 检查子类与父类的field继承关系
        Assert.assertEquals(baseObj_1.pubCount, baseObj_2.pubCount);
    }

    /***
     * 检查子类重写父类的方法
     */
    @Test
    public void checkOverideMethod(){
        try {
            baseObj_1.priDisplay();
            baseObj_2.priDisplay();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /***
     * 查找field的寻找路径
     */
    @Test
    public void checkFindField(){
        // 父类对象访问父类中的public独有属性
        System.out.println("find the field: " + baseObj_2.onlyPubCount);
        // 子类对象访问父类中的public独有属性
        System.out.println("find the field: " + subObj_1.onlyPubCount);
    }

}
