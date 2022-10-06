package abstractClass;

/**
 * @author Mr.wxx
 * @create 2022-10-02-0:03
 **/
public class MyDate {
    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }
}
