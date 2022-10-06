package abstractClass;

/**
 * @author Mr.wxx
 * @create 2022-10-01-22:29
 **/
public class SubClass extends AbsBaseClass{

    @Override
    protected void m1() {
        System.out.println(this.getClass().getName() + "类中的m1方法");
    }

    @Override
    protected void m2() {
        System.out.println(this.getClass().getName() + "类中的m2方法");
    }
}
