package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对象List与对象Array的转换
 *
 * @author Mr.wxx
 * @create 2022-11-13-16:16
 **/
public class SwitchListAndObjectArray {
    public static void main(String[] args) {
    }

    /**
     * 对象数组转换为对象List
     */
    public void objectArrayToList(){
        Integer[] integersArray = {1, 2, 3};
        // 1、使用Arrays.asList()
        List<Integer> integersList = Arrays.asList(integersArray);
        // 2、使用Collections.addAll()
        ArrayList<Integer> integersList2 = new ArrayList<>();
        Collections.addAll(integersList2,integersArray);
        // 3、使用Stream中的Collector
        List<Integer> integersList3 = Arrays.stream(integersArray).collect(Collectors.toList());
    }

    /**
     * 对象List转换为对象数组
     */
    public void listToObjectArray(){
        ArrayList<Integer> integersList = new ArrayList<>(Arrays.asList(1,2,3));
        // 1、toArray()方法
        Integer[] integersArray1 = integersList.toArray(new Integer[integersList.size()]);
        // 2、Stream流的toArray()方法
        Integer[] integersArray2 = integersList.stream().toArray(Integer[]::new);
    }


}
