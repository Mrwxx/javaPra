package genericClass;

import staticKey.Person;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Mr.wxx
 * @create 2022-10-05-12:10
 **/
public class GenericPra {
    public static void main(String[] args) {
        // 泛型可使用在类、接口、方法上，可作为非static属性的参数类型
    }

    public <E> E get(int id, E e){
        E result = null;
        return result;
    }

    public static <T extends Person> void test(T t){
        System.out.println(t);
    }

    /***
     * 有限制的通配符
     */
    public static void printColletion(Collection<? extends Person> coll){
        Iterator<? extends Person> iterator = coll.iterator();
    }

    public static void printCollection(Collection<? super Person> coll){

    }
}

class Father<T1, T2>{

}

class Son1<T1, T2> extends Father<T1, T2>{

}
