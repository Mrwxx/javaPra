package wxx.javaPra.anno.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-04-17-14:43
 **/
@Component
public class Man {
//    @Value(value = "wx")
    private String name;
//    @Value(value = "${man.age}")
    private int age;
    public Man(){

    }

    public Man(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
