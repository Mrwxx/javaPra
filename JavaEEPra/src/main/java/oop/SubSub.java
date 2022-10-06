package oop;

import java.io.FileNotFoundException;

/**
 * @author Mr.wxx
 * @create 2022-10-01-8:29
 **/
public class SubSub extends Sub {

    public SubSub(){
        System.out.println(SubSub.class.getName() + "类初始化");
    }

    @Override
    public void priDisplay() throws FileNotFoundException {
        super.priDisplay();
    }

    @Override
    public void pubDisplay() {
        super.pubDisplay();
    }
}
