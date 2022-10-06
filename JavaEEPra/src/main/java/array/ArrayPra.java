package array;

/**
 * @author Mr.wxx
 * @create 2022-07-21-21:56
 **/
public class ArrayPra {
    public static void main(String[] args) {
        //数组的声明，两种方式
        int[] arr1;
        int arr2[];

        //数组的初始化
        //1.动态初始化：必须指定数组的长度，数组长度不可变
        //基础数据类型各有各的默认值，引用数据类型默认为null
        int[] arr3 = new int[2];
        arr3[0] = 1;
        //2.静态初始化：声明数组并赋值
        int[] arr4 = new int[]{1,2,3};

        //多维数组：其实就是一维数组作为另一个一位数组的元素而存在，并没有所谓的多维数组
        //1.动态初始化多维数组：二维数组中有3个一维数组，每个一维数组中有2个元素
        int[][] arrMul1 = new int[3][2];
        arrMul1[0][0] = 1;
        //2.动态初始化：可以只指定第一维的数组长度,保证栈空间中的数组首地址能够找到即可
        int[][] arrMul2 = new int[3][];
        arrMul2[0] = new int[3];
        arrMul2[1] = new int[]{1,2,3};
        //3.静态初始化：不需要指定数组的二维长度，同时可以看到的是多维数组的长度并非是规则的
        int[][] arrMul3 = new int[][]{{1,2},{4,5,6}};
        //也可以去掉int[][]，直接进行赋值
        int[][] arrMul4 = {{1,2,3},{4,5,6}};



    }
}
