package inter.impl;

import inter.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author Mr.wxx
 * @create 2021-04-10-22:44
 **/
@Service
public class MyCalculator implements Calculator {
    public int add(int a, int b) {
        System.out.println(a+b);
        return a+b;
    }
}
