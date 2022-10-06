package abstractClass;

/**
 * 抽象基类
 *
 * @author Mr.wxx
 * @create 2022-10-01-22:23
 **/
public abstract class AbsBaseClass {
    //抽象类一定有构造方法
    public AbsBaseClass(){}
    protected abstract void m1();
    protected void m2(){
        System.out.println(AbsBaseClass.class.getName() + " 类中定义的m2方法");
    }
}
