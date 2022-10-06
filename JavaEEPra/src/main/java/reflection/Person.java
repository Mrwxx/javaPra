package reflection;

/**
 * @author Mr.wxx
 * @create 2021-03-27-10:03
 **/
public class Person {
    int age;
    String name;
    public int num;

    public Person(){}

    public void show(){
        System.out.println(name + " " + age + " " + num);
    }
    public void show(String money){
        System.out.println(name + " " + age + " " + num + money);
    }

    private static void test(){
        System.out.println("test");
    }
}
