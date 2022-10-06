package collection;

import com.fasterxml.jackson.databind.type.CollectionLikeType;

import java.util.*;

/**
 * Collections工具类练习
 * @author Mr.wxx
 * @create 2022-10-04-18:52
 **/
public class ColletionsPra {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        /***
         * 逆转排序
         */
        Collections.reverse(arrayList);
        /***
         * 根据元素的自然排序进行排序
         */
        Collections.sort(arrayList);
        /***
         * 根据指定的Comparator进行排序
         */
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        /***
         * 为list中的每个值填充指定的值
         */
        Collections.fill(arrayList, 2);

        /***
         * 创建多个指定值的list
         */
        List<Score> wxx = Collections.nCopies(2, new Score("wxx", 2));

        /***
         * 遍历输出list中的每个值
         */
        arrayList.stream().forEach(System.out::println);
    }
}
