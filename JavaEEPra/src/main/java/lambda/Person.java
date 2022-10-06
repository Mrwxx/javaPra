package lambda;

/**
 * @author Mr.wxx
 * @create 2021-03-28-19:40
 **/
public class Person {

    private int age;
    private String name;

    public Person(){

    }

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void test(){
        System.out.println("wxx");
    }

    public int getAge(){
        return age;
    }
}
