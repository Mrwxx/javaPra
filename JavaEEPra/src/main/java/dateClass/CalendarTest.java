package dateClass;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Mr.wxx
 * @create 2021-06-19-9:01
 **/
public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        //获取year年份时间
        int year = instance.get(Calendar.YEAR);
        System.out.println(year);
        //获取Date
        Date time = instance.getTime();
        System.out.println(time);
    }
}
