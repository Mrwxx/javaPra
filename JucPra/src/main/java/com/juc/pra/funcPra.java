package com.juc.pra;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Mr.wxx
 * @create 2021-05-06-10:57
 **/
public class funcPra {
    public static void main(String[] args) {
        Function<String, String> function = (str)->{return str;};
        System.out.println(function.apply("abs"));
        Predicate<String> predicate = (str) ->{return str.isEmpty();};
        System.out.println(predicate.test(""));
        Consumer<String> consumer = (str)->{ System.out.println(str); };
        consumer.accept("abs");
        Supplier<String> supplier = () -> {return "1024";};
        System.out.println(supplier.get());
    }
}
