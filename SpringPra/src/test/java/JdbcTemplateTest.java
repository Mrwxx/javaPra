import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Mr.wxx
 * @create 2021-04-11-16:45
 **/
public class JdbcTemplateTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("jdbc.xml");
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
//        jdbcTemplate.update();
//        Object o = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper < Person >);
    }
}
