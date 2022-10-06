package wrapper;

/**
 * @author Mr.wxx
 * @create 2022-08-09-15:51
 **/
public class Test {
    public static void main(String[] args) {
        //装箱
        Integer t = new Integer(500);
        Integer integer = Integer.valueOf(500);

        //拆箱
        int i = t.intValue();
        int i1 = Integer.parseInt("500");

        //自动装箱、拆箱
        Integer t2 = 500;
        int i2 = t2;

        //基本数据类型 ——> String类
        String s = String.valueOf(123);
        String s2 = 123 + "";

        //String类 -> 基本数据类型
        int i3 = Integer.parseInt(s);

        //包装类 -> String类
        String s1 = t2.toString();

        //String类 -> 包装类
        Float aFloat = new Float("1.2F");
        Integer integer1 = Integer.valueOf("1.2F");

    }
}
