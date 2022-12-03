package lambda;

import java.util.*;
import java.util.function.*;

/**
 * lambda表达式
 * @author Mr.wxx
 * @create 2021-03-28-10:12
 **/
public class Test {
    @org.junit.Test
    public void test1(){
        // 函数式接口，lambda表达式可以实现函数式接口
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("wxx");
        arrayList.add("aaa");
        List<String> a = find(arrayList, s -> s.contains("a"));
        a.forEach(b-> System.out.println(b));
        out(arrayList, System.out::println);
        Collections.sort(arrayList, (b, c) -> { return b.compareTo(c); });

        Comparator<Integer> t1 = (s1, s2) -> Integer.compare(s1,s2);
        Comparator<Integer> t2 = Integer::compare;
        Comparator<Integer> t3 = Integer::compareTo;
        System.out.println(t1.compare(1,2));
        System.out.println(t2.compare(3,1));
        System.out.println(t3.compare(3,1));

//        Function<Double, Long> function = new Function<Long>() {
//            @Override
//            public Long apply(Long o) {
//                return Math.round(o);
//            }
//
//            @Override
//            public Long apply(Double aDouble) {
//
//            }
//        };

        // 内置核心函数式接口的使用
        // 函数型接口
        Function<Double, Long> f2 = d-> Math.round(d);
        Function<Double, Long> f3 = Math::round;

        // 供给型接口
        // 将lambda表达式转为方法引用，也就是函数式接口的一个实例
        // 方法引用是已经有实现的lambda体，是语法糖
//        对象::实例方法名
//        类::静态方法名
//        类::实例方法名
        Supplier<Person> supplier = Person::new;
        Person person1 = supplier.get();
        BiFunction<String, Integer, Person> s2 = Person::new;
        Person wxx = s2.apply("wxx", 1);
        Function<Integer, Integer[]> f4 =  Integer[] :: new;
        Integer[] apply = f4.apply(2);

        Person person = new Person();
        Supplier<Integer> s1 = person::getAge;
        System.out.println(s1.get());

//        Consumer<Long> consumer = MyInter::cal;
    }

    public List<String> find(List<String> list, Predicate<String> pre){
        ArrayList<String> arrayList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    public List<String> out(List<String> list, Consumer<String> cons){
        ArrayList<String> arrayList = new ArrayList<>();
        for(String s : list){
            cons.accept(s);
        }
        return arrayList;
    }

    @org.junit.Test
    public void test2(){
        String s = toUpper((str)-> str.toUpperCase() , "aaaa");
        System.out.println(s);

        int[] a = new int[]{1,2};
        Integer[] at = new Integer[a.length];
        for(int i = 0; i < a.length; ++i){
            at[i] = a[i];
        }
        Arrays.sort(at, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public String toUpper(MyInter<String> mf, String str){
        return mf.getValue(str);
    }
}

//函数式接口
@FunctionalInterface
interface MyInter<T>{
    public abstract T getValue(T t);

    default void cal(T t){
        System.out.println(t);
    }
}
