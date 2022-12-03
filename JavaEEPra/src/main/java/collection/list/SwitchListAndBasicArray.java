package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对象List与基本数据类型数组的转换
 *
 * @author Mr.wxx
 * @create 2022-11-13-16:18
 **/
public class SwitchListAndBasicArray {
    /**
     * 对象List转换为基本数据类型数组
     */
    public void listToBasicArray(){
        ArrayList<Integer> integersList = new ArrayList<>(Arrays.asList(1,2,3));
        // 1、Stream流执行转换
        // 方法引用
        int[] arrays1 = integersList.stream().mapToInt(Integer::intValue).toArray();
        // lambda表达式
        int[] arrays2 = integersList.stream().mapToInt(i -> i).toArray();

    }

    /**
     * 基本数据类型数组转换为对象List
     */
    public void basicArrayToList(){
        int[] integersArray = {1, 2, 3};
        // 1、Stream流转换
        List<Integer> integersList = Arrays.stream(integersArray).mapToObj(Integer::new).collect(Collectors.toList());

    }
}
