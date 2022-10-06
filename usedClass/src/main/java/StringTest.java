/**
 * @author Mr.wxx
 * @create 2021-06-19-8:28
 **/
public class StringTest {
    public static void main(String[] args) {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuilder sbi = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 2000000; ++i){
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的速度" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 2000000; ++i){
            sbi.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的速度" + (endTime - startTime));        startTime = System.currentTimeMillis();
        for(int i = 0; i < 20000000; ++i){
            sbf.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的速度" + (endTime - startTime));
    }
}
