package innerClass;

/**
 * @author Mr.wxx
 * @create 2022-10-02-10:39
 **/
public class Outer {
    private int priField ;
    public int pubField;

    private static int priStaticField;
    public static int pubStaticField;

    // public内部类
    class Inner{
        // 内部类的属性
        private int priInnerField;
        public int pubInnerField;

        // 为外部类的属性赋值
        public void setOuterField(){
            // 访问外部类的public属性
            pubField = 2;
            // 访问外部类的private属性
            priField = 1;
            // 访问外部类的属性
            Outer.this.priField = 3;
            // 访问内部类的属性
            this.pubInnerField = 4;

        }

        // 为内部类的属性赋值
        private void setInnerField(){
            priInnerField = 3;
            pubInnerField = 4;
        }
    }

    // static内部类
    static class staticInner{
        // 内部类的属性
        private int priStaticInnerField;
        public int pubStaticInnerField;

        // 为内部类的static属性赋值
        public static void setInnerField(){
            priStaticField = 3;
            pubStaticField = 4;
        }
    }


    // 调用内部类中的成员
    public void m2(){
        Inner inner = new Inner();
        inner.setOuterField();
    }
}
