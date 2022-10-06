package enumClass;

/**
 * @author Mr.wxx
 * @create 2021-06-19-10:21
 **/
public class EnumTest {
    public static void main(String[] args) {
        SeasonEnum autumn = SeasonEnum.AUTUMN;
        System.out.println(autumn.getSeasonName());
        System.out.println(autumn.getSeasonNum());
        System.out.println(autumn.name());
        SeasonEnum[] values = SeasonEnum.values();
    }
}

// 枚举类可实现接口
enum SeasonEnum implements Show {
    // 每个枚举实例都可以重写方法，不同实例可以有不同的逻辑
    SPRING("spring", "1"){
        public void start() {
            System.out.println("spring");
        }
    },
    SUMMER("summer", "2") {
        public void start() {
            System.out.println("summer");
        }
    },
    AUTUMN("autumn", "3") {
        public void start() {
            System.out.println("autumn");
        }
    },
    WINTER("winter", "4") {
        public void start() {
            System.out.println("winter");
        }
    };

    private final String seasonName;
    private final String seasonNum;
    //私有构造器
    private SeasonEnum(String seasonName, String seasonNum){
        this.seasonName = seasonName;
        this.seasonNum = seasonNum;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonNum() {
        return seasonNum;
    }

}
