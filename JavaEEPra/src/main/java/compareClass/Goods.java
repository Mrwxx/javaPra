package compareClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.wxx
 * @create 2021-06-19-9:44
 **/
public class Goods implements Comparable {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //按照价格，首先比较商品的大小，其次比较name的字典序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods other = (Goods) o;
            if (this.price > other.price) {
                return 1;
            } else if (this.price < other.price) {
                return -1;
            }else{
                // price相等，name字典序排序
                return ((Goods)o).name.compareTo(this.name);
            }
        }
        throw new RuntimeException("输入的数据类型不一致");
    }

    @Override
    public String toString() {
        return this.name + "的价格为：" + this.price;
    }

    //构造器、getter、setter、toString()方法略

    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("War and Peace", 100);
        all[1] = new Goods("Childhood", 80);
        all[2] = new Goods("Notre Dame de Paris", 120);
        all[3] = new Goods("aotre Dame de Paris", 120);
        // 通过Comparator匿名对象传入比较器，构造比较规则compare
        // 传入两个对象进行比较
        Arrays.sort(all, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return g1.compareTo(g2);
            }
        });
        // 通过对象内部实现的Comparable接口构造比较规则compareTo
        // this对象与传入的对象比较，不需要传入Comparator构造器
        Arrays.sort(all);

        for (Goods goods : all) {
            System.out.println(goods.toString());
        }
    }
}
