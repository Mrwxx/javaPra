package functionalInterface;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Mr.wxx
 * @create 2022-10-07-10:53
 **/
public class funcTest {
    public static void main(String[] args) {

    }

    /***
     * JAVA内置消费型接口 Consumer<T></>
     */
    @Test
    public void consumerTest(){
        // 传入单个参数，执行消费操作，不返回任何值
        // 有多种写法，如lambada表达式、匿名实现类、方法引用
        Consumer<String> strCon1 = str -> System.out.println(str);
        Consumer<String> strCon2 = System.out::println;
        Consumer<String> strCon3 =  new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
    }

    /***
     * JAVA内置供给型接口 Supplier
     */
    @Test
    public void supplierTest(){
        // 没有参数，返回一个参数，只提供返回值
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "123";
            }
        };
        Supplier<String> supplier2 = () -> "ab".toUpperCase();
    }

    /***
     * JAVA内置函数型接口 Function
     */
    @Test
    public void functionTest(){
        // 有一个参数，有一个返回值，像函数一样
        // 匿名实现类
        Function<String, String> function1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        // lambda表达式
        Function<String, String> function2 = a -> a.toUpperCase();
        // 方法引用
        Function<String, String> function3 = String::toUpperCase;
    }

    /***
     * JAVA内置断定型接口 Predicate
     */
    @Test
    public void predicateTest(){
        // 有一个参数，返回值为boolean，用来判断
        Predicate<String> predicate1 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        Predicate<String> predicate2 = s -> s.isEmpty();
        Predicate<String> predicate3 = String::isEmpty;
    }

    /***
     * 调用自定义的函数式接口，泛型方法
     * @return
     */
    public <T> void printStr(ConFunc<T> con, T t){
        con.consu(t);
    }

    /***
     * 测试调用上面的方法，实现自定义的函数式接口
     */
    @Test
    public void printStrTest(){
        // 1.lambda表达式
        printStr(str -> System.out.println(str), 123);
        printStr(str -> System.out.println(str), "123");
        // 2.方法引用
        printStr(System.out::println, "123");
        // 3.匿名实现类
        printStr(new ConFunc<String>() {
            @Override
            public void consu(String s) {
                System.out.println(s);
            }
        }, "123");
    }
}

/***
 * 自定义函数式接口
 * @param <T>
 */
@FunctionalInterface
interface ConFunc<T>{
    // 消费型接口
    void consu(T t);
}
