package collection;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

/**
 * @author Mr.wxx
 * @create 2022-07-17-10:46
 **/
public class ArrayListPra {
    public static void main(String[] args) {
        //初始化，不填充
        ArrayList<Integer> integers1 = new ArrayList<Integer>();

        /***
         * ArrayList的赋值
         */
        // 1. 普通单个赋值
        integers1.add(1);

        // 2. 初始化一次填充多个值,asList有很多坑，直接生成List则无法使用add(),remove()等方法
        //如下的方式为一次性为ArrayList赋多个值，可使用add()、remove()等方法
        ArrayList<Integer> integers2 = new ArrayList<Integer>();
        List<Integer> list = Arrays.asList(1, 2, 3);
        integers2.addAll(list);

        // 3. 同时填充多个相同的值
        ArrayList<Integer> integers3 = new ArrayList<Integer>(Collections.nCopies(2, 5));
        // 匿名类填充多个值

        // 删除指定值
        integers2.remove(1);
        integers1.set(0, 2);

        for (Integer integer : integers1) {
            System.out.println(integer);
        }
        for (Integer integer : integers2) {
            System.out.println(integer);
        }

        /*
ArrayList的常用方法：
    public boolean add(E e): 向集合中添加元素，参数的类型和泛型一致
    备注：对于ArrayList集合来说，add动作一定是成功的，所以返回值不可用
    但是对于其他集合来说，add的添加动作不一定成功。

    public E get(int index): 从集合中获取元素，参数书索引编号，返回值是对应位置的元素
    public E remove(int index): 从集合中删除元素，参数是索引编号，返回值就是被删除的元素
    public int size(): 获取集合尺寸的长度，返回值是集合中包含元素的个数。
 */
        /***
         * ArrayList的遍历
         */
        // 1. for循环
        for (int i = 0; i < integers1.size(); i++) {
            System.out.println(integers1.get(i));
        }
        // 2. 增强for循环
        for (Integer integer : integers1) {
            System.out.println(integer);
        }
        // 3. forEach
        integers1.forEach( s -> {
            System.out.println(s);
        });

        integers1.forEach(System.out::println);

        // 4. iterator遍历
        Iterator<Integer> iterator = integers1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /***
         * ArrayList转Array
         *
         */
        Integer[] integers = integers1.toArray(new Integer[]{});

        /***
         * ArrayList转HashSet
         */
        HashSet<Integer> integers4 = new HashSet<>(integers1);

    }
}
