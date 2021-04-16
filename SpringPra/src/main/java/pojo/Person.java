package pojo;

/**
 * @author Mr.wxx
 * @create 2021-04-08-23:36
 **/
public class Person {
    private int age;
    private String name;
    private String addr;

    public Person() {
        System.out.println("Person的空参构造器");
    }

    public void myInit(){
        System.out.println("Person的初始化");
    }

    public void myDestroy(){
        System.out.println("Person的销毁");
    }

    public Person(int age, String name, String addr) {
        this.age = age;
        this.name = name;
        this.addr = addr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
