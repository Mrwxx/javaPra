package object;

/**
 * @author Mr.wxx
 * @create 2022-08-08-14:40
 **/
public class Test {
    public static void main(String[] args) {
        Object o = new Object();

        //toString()方法
        System.out.println("Object对象的toString()方法返回值：" + o.toString());
        String s = new String("123");
        System.out.println("String对象的toString()方法返回值：" + s.toString());
        Integer integer = new Integer(1);
        System.out.println("Integer对象的toString()方法返回值：" + integer.toString());


    }
}
