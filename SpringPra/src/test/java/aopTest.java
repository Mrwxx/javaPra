import inter.Calculator;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.wxx
 * @create 2021-04-11-9:40
 **/
public class aopTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,2);
    }
}
