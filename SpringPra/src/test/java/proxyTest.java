import inter.Calculator;
import inter.impl.MyCalculator;
import org.junit.Test;
import proxy.CalculatorProxy;

/**
 * @author Mr.wxx
 * @create 2021-04-10-22:54
 **/
public class proxyTest {

    @Test
    public void test(){
        Calculator calculator = new MyCalculator();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        proxy.add(1,2);
    }
}
