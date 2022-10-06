package oop;

import java.io.FileNotFoundException;

/**
 * @author Mr.wxx
 * @create 2022-08-06-16:16
 **/
public class Sub extends Base {
    public int pubCount = 30;
    private int priCount = 40;

    public Sub(){
        super();
        System.out.println(super.getClass().getName() + "类初始化");
    }

    public Sub(int pubCount, int priCount){
        this();
        this.pubCount = pubCount;
        this.priCount = priCount;
    }

    @Override
    public void priDisplay() throws FileNotFoundException {
        System.out.println("private  field = " + this.priCount);
    }

    @Override
    public void pubDisplay(){
        System.out.println("public field =" + this.pubCount);
    }
}
