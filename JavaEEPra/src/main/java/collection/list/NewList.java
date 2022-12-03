package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mr.wxx
 * @create 2022-11-13-16:15
 **/
public class NewList {
    public static void main(String[] args) {

        // 1、基本构造方法
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);

        // 2、Arrays.asList()
        List<Integer> integerArrayList2 = Arrays.asList(1, 2, 3);

        // 3、new ArrayList<>(Arrays.asList(T... a))
        ArrayList<Integer> integerArrayList3 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 4、Stream流的collect终结方法
        List<Integer> integerArrayList4 = Stream.of(1, 2, 3).collect(Collectors.toList());

        // 5、guava提供的Lists.newArrayList(T... a)

    }
}
