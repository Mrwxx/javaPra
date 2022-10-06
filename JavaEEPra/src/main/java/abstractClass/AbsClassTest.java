package abstractClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.wxx
 * @create 2022-10-01-22:31
 **/
public class AbsClassTest {
    private AbsBaseClass absBaseClass;
    private SubClass subClass;
    @Before
    public void setUp() throws Exception {
        // 子类可创建对象
        subClass = new SubClass();
        // 抽象父类创建匿名对象
        absBaseClass = new AbsBaseClass() {
            @Override
            protected void m1() {
                System.out.println(this.getClass().getName() + "类初始化");
            }
        };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void m1() {
        // 子类对象可调用重写的抽象方法m1
        subClass.m1();
        // 子类对象可调用抽象类基类的普通方法m2
        subClass.m2();

        // 父类对象调用匿名对象的m1方法
        absBaseClass.m1();
    }

    @Test
    public void m2() {
    }
}