package collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mr.wxx
 * @create 2022-10-04-17:36
 **/
public class MapPra {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("wxx", 100);
        map.put("wxa", 99);
        /***
         * HashMap的遍历，遍历map的entrySet集合
         * map.entrySet().for 可以快速得到如下结果
         */
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value = stringIntegerEntry.getValue();
        }
        /***
         * 判断map中是否有指定的value
         */
        if(map.containsValue(100)){
            System.out.println("map中存在");
        }
        /***
         * TreeMap中元素的排序，只能对key进行排序
         */
        TreeMap<Score, Integer> scoreIntegerTreeMap = new TreeMap<>();
        scoreIntegerTreeMap.put(new Score("wxx", 100), 1);
        scoreIntegerTreeMap.put(new Score("wxa", 99), 2);

    }
}
