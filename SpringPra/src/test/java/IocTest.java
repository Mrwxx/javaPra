import javafx.scene.chart.PieChart;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Person;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Mr.wxx
 * @create 2021-04-08-23:41
 **/
public class IocTest {

    @Test
    public void test1(){
        // ioc容器测试，通过类路径下的XML配置文件得到ioc容器
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person1 = (Person)ioc.getBean("person1");
        System.out.println(person1);
        Person person21 = ioc.getBean("person2", Person.class);
        System.out.println(person21);
        Person person3 = (Person)ioc.getBean("person3");
        System.out.println(person3);
        ioc.close();

        DataSource dataSource = (DataSource)ioc.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = (DataSource)ioc.getBean("dataSource");
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
