package process;

/**
 * @author Mr.wxx
 * @create 2022-07-21-20:46
 **/
public class SwitchPra {
    public static void main(String[] args) {
        String season = "summers";
        switch (season){
            case "spring":
                System.out.println("the season is spring!");
                //break语句能够直接跳出switch语句
                break;
            case "summer":
                System.out.println("the season is summer!");
                break;
                //default的位置是无所谓的，default执行完之后也会继续向下执行
            default:
                System.out.println("no season!");
            case "autumn":
                System.out.println("the season is autumn!");
                break;
            case "winter":
                System.out.println("the season is winter!");
                break;

        }
    }


}
