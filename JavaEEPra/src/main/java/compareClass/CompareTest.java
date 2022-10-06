package compareClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.wxx
 * @create 2021-06-19-9:49
 **/
public class CompareTest {
    public static void main(String[] args) {
        Goods[] all = new Goods[4];
        all[0] = new Goods("War and Peace", 100);
        all[1] = new Goods("Childhood", 80);
        all[2] = new Goods("Scarlet and Black", 140);
        all[3] = new Goods("Notre Dame de Paris", 120);
        Arrays.sort(all, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Goods g1 = (Goods) o1;
                Goods g2 = (Goods) o2;
                return g1.getName().compareTo(g2.getName());
            }
        });
        System.out.println(Arrays.toString(all));
    }
}
