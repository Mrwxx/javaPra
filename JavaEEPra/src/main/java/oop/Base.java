package oop;

import java.io.FileNotFoundException;

/**
 * @author Mr.wxx
 * @create 2022-08-06-16:15
 **/
public class Base {
    public int pubCount = 10;
    private int priCount = 20;
    public int onlyPubCount = 100;
    protected int onlyProCount = 110;
    private int onlyPriCount = 120;
    int onlyDefCount = 130;

    public Base(){
        System.out.println(this.getClass().getName() + "类初始化");
    }

    public Base(int pubCount, int priCount) {
        this();
        this.pubCount = pubCount;
        this.priCount = priCount;
    }

    public int getPubCount() {
        return pubCount;
    }

    public void setPubCount(int pubCount) {
        this.pubCount = pubCount;
    }

    public int getPriCount() {
        return priCount;
    }

    public void setPriCount(int priCount) {
        this.priCount = priCount;
    }

    public void priDisplay() throws FileNotFoundException {
        System.out.println("private field =  " + this.priCount);
    }

    public void pubDisplay(){
        System.out.println("public filed = " + this.pubCount);
    }
}
