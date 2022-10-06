import java.util.Date;

/**
 * @author Mr.wxx
 * @create 2021-06-19-8:35
 **/
public class DateTest {
    public static void main(String[] args) {
        Date now = new Date();
        long time = now.getTime();
        System.out.println(time);
        System.out.println(now.toString());
    }
}
