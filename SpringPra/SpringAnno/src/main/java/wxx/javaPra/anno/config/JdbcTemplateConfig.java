package wxx.javaPra.anno.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mr.wxx
 * @create 2021-06-26-14:41
 **/
@Configuration
public class JdbcTemplateConfig {
    @Bean
    public DataSource getDataSource(){
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("classpath://dataSource.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //添加Druid数据源
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(properties.getProperty("username"));
        druidDataSource.setPassword(properties.getProperty("password"));
        druidDataSource.setDriverClassName(properties.getProperty("driver"));
        druidDataSource.setUrl(properties.getProperty("url"));
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate getJdbc(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
