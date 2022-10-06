package mode;

public abstract class Template {

    public abstract void add();
    public void addt(){
        System.out.println("aaa");
    }
    public NullPointerException exception = new NullPointerException();

    public static void main(String[] args) {
        try {
            int[] a = null;
            System.out.println(a[3] + 2);
            throw new RuntimeException("aaa");
        } catch (Exception e) {

            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.toString();
        }
    }
}

interface aa{
    public static final int a = 1;
    int b =2;
    public abstract int add();
    public static int adde(){
        return 1;
    }
    default int addd(){
        return 1;
    }
    default  int addc(){
        return 1;
    }
}
