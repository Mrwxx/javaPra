package optional;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {

        ArrayList<String> stringArrayList = new ArrayList<String>();
        Optional<String> q = stringArrayList.stream().filter(d -> d.startsWith("Q")).findFirst();
        //String s = q.orElse("");
        String s1 = q.orElseGet(() -> System.getProperty("myqpp.default"));
//        String s2 = q.orElseThrow(IllegalStateException::new);

        q.ifPresent(stringArrayList::add);
        q.ifPresent(v->stringArrayList.add(v));
//        q.ifPresentOrElse(v-> System.out.println("Found"+v),
//                () -> System.out.println("error"));
        Optional<String> s3 = q.map(String::toUpperCase);
        q.filter(d->d.length() >= 8).map(String::toUpperCase);
//        String s4 = q.get();
        boolean present = q.isPresent();
        String nothing_else = q.orElse("nothing else");
//        String s6 = q.orElseGet(String::toUpperCase);

        Optional<Integer> integer = Optional.of(1);
        Optional<Object> empty = Optional.empty();
//        Stream<String> stream = q.stream();
//        //Optional<Object> o = q.map(Optional::stream);
//
//        stream.forEach(System.out::println);
//        stream.forEachOrdered(System.out::println);
//        String[] strings = stream.toArray(String[]::new);
//        List<String> collect = stream.collect(Collectors.toList());
//        TreeSet<String> collect1 = stream.collect(Collectors.toCollection(TreeSet::new));

        //stream.collect(Collectors.toMap(Person::getId(), Person()::getName()));
//        stream.collect(COllectors.toMap(Locale.getAvailableLocales(),
//                Person::getID(),
//                (ex, newd) -> {throw new IllegalStateException();},
//                TreeMap::new));
    }

    /***
     * 创建Optional，Optional<T> 类(java.util.Optional) 是一个容器类，它可以保存类型T的值，代表
     * 这个值存在。或者仅仅保存null，表示这个值不存在。原来用 null 表示一个值不
     * 存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
     */
    @Test
    public void createOptionalTest(){
        // 非空的Optional实例
        Optional<String> s1 = Optional.of("123");
        // 空的Optional实例
        Optional<Object> s2Empty = Optional.empty();
        // 可以包装null的Optional实例
        Optional<Object> s3Null = Optional.ofNullable(null);
        // Stream的终结操作也会返回Optional
        ArrayList<String> stringArrayList = new ArrayList<String>();
        Optional<String> q = stringArrayList.stream().filter(d -> d.startsWith("Q")).findFirst();
    }

    /***
     * 判断Optional容器中是否包含对象
     */
    @Test
    public void judgeOptionalTest(){
        // 非空的Optional实例
        Optional<String> s1 = Optional.of("123");
        // 判断是否包含对象
        boolean present = s1.isPresent();
        // 如果有值，则执行Conusmer实现逻辑
        s1.ifPresent(System.out::print);
    }

    /***
     * 获取Optional 容器的对象
     */
    @Test
    public void getOptionalTest(){
        // 非空的Optional实例
        Optional<String> s1 = Optional.of("123");
        // 如果没有值，则会抛出异常
        String s = s1.get();
        // 如果没有值，则会返回指定对象
        String nothing = s1.orElse("nothing");
        // 如果没有值，则会返回Supplier接口提供的值
        String s2 = s1.orElseGet(() -> "nothing");
        // 如果没有值，则会抛出提供的异常
        try {
            String nothing1 = s1.orElseThrow(() -> new Exception("nothing"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 获取Optional 容器的对象
     */
    @Test
    public void optionalStreamTest(){
        // 非空的Optional实例
        Optional<List<String>> s1 = Optional.of(new ArrayList<String>(Arrays.asList("abcdef", "abcde")));
        // Optional还可以执行filter、map、flatMap等操作

    }

    public static Stream<String> noVowels() throws IOException {
//        String contents = new String(Files.readAllBytes(Paths.get("../eg.txt")), StandardCharsets.UTF_8);
//        List<String> split = List.of(contents.split("\\PL+"));
//        Stream<String> stream = split.stream();
//        return stream.map(s->s.replaceAll("[sdf]", ""));
        return null;
    }


}
