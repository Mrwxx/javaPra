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

    @org.junit.Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        Stream<String> stream = list.stream();
        Stream<String> parStream = list.parallelStream();
        
        int[] array = new int[2];
        IntStream stream1 = Arrays.stream(array);

        Stream<Integer> iterate = Stream.iterate(0, a -> a + 2);
        Stream<Double> generate = Stream.generate(Math::random);
        iterate.limit(10).forEach(System.out::println);
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
