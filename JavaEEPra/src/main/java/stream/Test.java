package stream;

import lambda.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Mr.wxx
 * @create 2021-03-28-20:14
 **/
public class Test {
    /***
     * 创建Stream流的多种方式
     */
    @org.junit.Test
    public void createStreamTest(){
        // 1.集合的stream()方法调用得到Stream流
        List<String> list = new ArrayList<String>();
        Stream<String> stream = list.stream();
        Stream<String> parStream = list.parallelStream();

        // 2.Arrays.stream静态方法得到Stream流
        int[] array = new int[2];
        IntStream stream1 = Arrays.stream(array);

        // 3.Stream.of()获取Stream流
        Stream<List<String>> list1 = Stream.of(list);

        // 4.Stream.iterate()不断执行某种操作
        Stream<Integer> iterate = Stream.iterate(0, a -> a + 2);
        iterate.limit(10).forEach(System.out::println);

        // 5.Stream.generate()不断创建某个对象
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10).forEach(System.out::println);

        ArrayList<String> arrayList = new ArrayList<>();
        Stream<Stream<String>> streamStream = stream.map(this::pack);
        streamStream.forEach(a -> {
            a.forEach(System.out::println);
        });
        Stream<String> rStream = stream.flatMap(this::pack);
        rStream.forEach(System.out::println);
        Set<String> collect = list.stream().collect(Collectors.toSet());
    }

    /***
     * Stream的中间操作filter，从流中排除某些元素
     */
    @org.junit.Test
    public void streamFilterTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("12345", "12345", "123"));
        Stream<String> arrayListStream = strings.stream();
        // filter筛选，过滤String的长度>=5的String并最终输出
        arrayListStream.filter(a -> a.length() >= 5).forEach(System.out::println);
    }

    /***
     * Stream的中间操作limit，截断流，使其元素不超过给定数量
     */
    @org.junit.Test
    public void streamLimitTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("123456", "12345", "123"));
        Stream<String> arrayListStream = strings.stream();
        // filter以及limit筛选，过滤String的长度>=5的第一个String并最终输出
        arrayListStream.filter(a -> a.length() >= 5).limit(1).forEach(System.out::println);
    }

    /***
     * Stream的中间操作skip，跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一
     * 个空流。与 limit(n) 互补
     */
    @org.junit.Test
    public void streamSkipTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("123456", "12345", "123"));
        Stream<String> arrayListStream = strings.stream();
        // filter以及limit筛选，过滤String的长度>=5的两个String，并最终跳过第一个输出第二个
        arrayListStream.filter(a -> a.length() >= 5).limit(2).skip(1).forEach(System.out::println);
    }

    /***
     * Stream的中间操作map, 接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * 如果函数返回值是Stream,那么就会出现Stream中嵌套多个Stream的结果，如Stream<Stream<String>></>></>
     */
    @org.junit.Test
    public void streamMapTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        Stream<String> arrayListStream = strings.stream();
        // map接受一个Function函数式接口实现，对每个元素执行function操作，返回的还是多个元素
        // 下面的map中传入操作为对每个String执行转大写
        arrayListStream.map(String::toUpperCase).forEach(System.out::println);
    }

    /***
     * Stream的中间操作map, 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     * 就算函数返回值是Stream，也会将所有的Stream中的数值取出来，连接为一个Stream，如Stream<String></>
     * 适用于嵌套list数据结构，想把内部的list数据合并成一个list
     */
    @org.junit.Test
    public void streamFlatMapTest(){
        // ArrayList初始化
        ArrayList<String> strings1 = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        ArrayList<String> strings2 = new ArrayList<>(Arrays.asList("123456", "12345", "123"));
        ArrayList<List<String>> listLists = new ArrayList<List<String>>();
        listLists.add(strings1);
        listLists.add(strings2);
        // flatMap的作用可以将上面嵌套的List<List<String>>中的所有String扁平化保存到一个List中
        // 使用collect最终将元素存储到List中
        List<String> collect = listLists.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /***
     * Stream的中间操作sorted，自然排序与比较器排序
     */
    @org.junit.Test
    public void streamSortedTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        Stream<String> arrayListStream = strings.stream();
        // 自然排序，注意一个流执行了终止操作后就不能再次使用了
//        arrayListStream.sorted().forEach(System.out::println);
        // 比较器排序
        arrayListStream.sorted((a,b)-> a.compareTo(b)).forEach(System.out::println);
    }

    /***
     * Stream的终止操作，count计数
     */
    @org.junit.Test
    public void streamCountTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        Stream<String> arrayListStream = strings.stream();
        System.out.println(arrayListStream.filter(a -> a.length() >= 5).count());
    }

    /***
     * Stream的终止操作，max与min最大值最小值
     */
    @org.junit.Test
    public void streamMaxMinTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        Stream<String> arrayListStream = strings.stream();
        // 返回的是一个Optional
        System.out.println(arrayListStream.filter(a -> a.length() >= 5).max((a,b) -> a.compareTo(b)));
    }

    /***
     * Stream的终止操作，reduce规约操作，可以将流中元素反复结合起来，得到一个值。返回 T
     */
    @org.junit.Test
    public void streamReduceTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcde", "abc"));
        Stream<String> arrayListStream = strings.stream();
        // 返回的是一个Optional，将List中的String都相加
        System.out.println(arrayListStream.filter(a -> a.length() >= 5).reduce((a,b) -> a+b));
    }

    /***
     * Stream的终止操作，collect将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。
     另外， Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例
     */
    @org.junit.Test
    public void streamCollectTest(){
        // ArrayList初始化
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("abcdef", "abcdef", "abc"));
        Stream<String> arrayListStream = strings.stream();
        // 将List中所有元素存储到Set中
        arrayListStream.filter(a -> a.length() >= 5).limit(2).collect(Collectors.toSet()).forEach(System.out::println);
        // 将List中的所有String连接为一个String
        System.out.println(arrayListStream.filter(a -> a.length() >= 5).limit(2).collect(Collectors.joining()));
    }



    public Stream<String> pack(String s){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(s);
        Stream<String> stream = arrayList.stream();
        return stream;
    }

    @org.junit.Test
    public void test2(){
        Person person = new Person();
        person = null;
        Optional<Person> person1 = Optional.ofNullable(person);
        System.out.println(person1.isPresent());
//        System.out.println(person1.isEmpty());
        Person wxx = person1.orElse(new Person("wxx", 1));
        System.out.println(wxx.getAge());
    }
}

@FunctionalInterface
interface MyFunc<T>{
    T mf(T t);
}