package dateClass;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Mr.wxx
 * @create 2021-06-19-9:18
 **/
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        System.out.println(month);

//        DateTimeFormatter.ofLocalizedTime()

    }
}
