package staticKey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2022-08-12-21:47
 **/
public class Person {
    private int id;
    public static int total = 0;
    public Person(){
        total++;
        id=total;
    }

    public static void eat(){
        System.out.println("static方法eat");
    }

    public static void main(String[] args) {
        Person wx = new Person();
        //通过对象访问static变量
        wx.total ++;
        System.out.println(Person.total);
        //通过类名.类属性访问static变量
        Person.total ++;
        System.out.println(Person.total);

        //通过类名.类方法访问static方法
        Person.eat();
        //通过对象.类方法访问static方法
        wx.eat();

        HashSet<Integer> integers1 = new HashSet<Integer>();
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Integer> integers2 = new ArrayList<Integer>(integers1);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

    }
}
