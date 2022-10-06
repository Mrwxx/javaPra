package dateClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr.wxx
 * @create 2021-06-19-8:48
 **/
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String pattern = "yyyy年MM月dd日 EEE HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String now = sdf.format(new Date());
        System.out.println(now);

    }
}
