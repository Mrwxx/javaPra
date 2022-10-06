package collection;

import java.util.TreeSet;

/**
 * @author Mr.wxx
 * @create 2022-10-04-17:17
 **/
public class SetPra {
    public static void main(String[] args) {
        /***
         * TreeSet使用，可排序的Set
         * 自然比较，不传入Comparator比较器
         */
        TreeSet<Score> scores = new TreeSet<>();
        scores.add(new Score("wxx", 100));
        scores.add(new Score("wxa", 98));
        scores.add(new Score("wxb", 99));
        scores.add(new Score("wxc", 98));
        for (Score score : scores) {
            System.out.println(score.getStuName() + "的Score为：" + score.getStuScore());
        }
        /***
         * 排序结果：
        wxa的Score为：98
        wxc的Score为：98
        wxb的Score为：99
        wxx的Score为：100
         ***/
    }
}

class Score implements Comparable{
    private String stuName;
    private int stuScore;

    public Score(String stuName, int stuScore){
        this.stuName = stuName;
        this.stuScore = stuScore;
    }

    public String getStuName(){
        return stuName;
    }

    public int getStuScore(){
        return stuScore;
    }

    @Override
    public int compareTo(Object o) {
        // 先比较score，int按照升序
        if(o instanceof Score){
            Score stu = (Score)o;
            if(this.stuScore > stu.stuScore){
                return 1;
            }else if(this.stuScore < stu.stuScore){
                return -1;
            }else{
                // 再比较name，String按照字典序升序
                return this.stuName.compareTo(stu.stuName);
            }
        }
        return 0;
    }
}