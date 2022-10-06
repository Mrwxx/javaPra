package enumClass;

/**
 * @author Mr.wxx
 * @create 2021-06-19-10:15
 **/
public class MyEnum {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(Season.AUTUMN);

        // 获取枚举值的属性
        System.out.println("Season.AUTUMN枚举值的季节名称：" + autumn.getSeasonName());
        System.out.println("Season.AUTUMN枚举值的季节描述：" + autumn.getSeaonDesc());
    }
}

class Season{
    private final String SEASONNAME;//季节的名称
    private final String SEASONDESC;//季节的描述
    private Season(String seasonName,String seasonDesc){
        this.SEASONNAME = seasonName;
        this.SEASONDESC = seasonDesc;
    }
    public String getSeasonName(){
        return this.SEASONNAME;
    }
    public String getSeaonDesc(){
        return this.SEASONDESC;
    }
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");
}