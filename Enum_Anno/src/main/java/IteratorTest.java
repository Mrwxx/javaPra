import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-06-19-15:41
 **/
public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        //回到初始的起点
        Iterator<Integer> iterator = integers.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        int[] ans = new int[]{1,2};
        List<int[]> ints = Arrays.asList(ans);
    }
}
