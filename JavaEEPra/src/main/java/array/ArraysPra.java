package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.wxx
 * @create 2022-07-22-10:33
 * Arrays工具类的测试
 **/
public class ArraysPra {
    public static void main(String[] args) {
        Integer[] intArr1 = new Integer[]{3,2,1};

        //Arrays.sort
        //1.普通的sort排序
        Arrays.sort(intArr1);

        //2.范围的sort排序
        Arrays.sort(intArr1, 0, 2);
        //3.自定义Comparator排序规则
        Arrays.sort(intArr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //递增排序，o1 < o2，则return 负值
                return o1-o2;
            }
        });

        //考虑数值溢出的写法
        Arrays.sort(intArr1,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                if(o1 > o2)return 1;
                else if(o1 < o2)return -1;
                else return 0;
            }
        });

        //lambda表达式的简洁写法
        Arrays.sort(intArr1, (p1, p2) -> p1 < p2 ? -1 : 1);


//        Arrays.copyOf(),复制数组为新的数组
        Integer[] intArr2 = Arrays.copyOf(intArr1, 5);
        System.out.println("copyOf得到的新的数组长度为：" + intArr2.length);

        //填充指定值到数组的每个元素中，源码解析
        Arrays.fill(intArr2, 3);

        //Arrays.equals()，判断两个数组是否相同，每个元素是否相等
        boolean equals = Arrays.equals(intArr1, intArr2);
        System.out.println("数组1和数组2是否相等：" + equals);

        for (Integer integer : intArr2) {
            System.out.println(integer);
        }

    }
}
