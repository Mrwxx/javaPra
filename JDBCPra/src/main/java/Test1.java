import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import util.JDBCUtils;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * @author Mr.wxx
 * @create 2021-03-31-15:47
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
//        test1.test1();
//        test1.test2();
//        test1.test3();
//        String sql = "select * from user";
//        User query = GenericSql.query(User.class, sql);
//        System.out.println(query);
//        test1.test5();
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection connection = null;
        try {
            connection = cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }

    @Test
    public void test1(){
        Connection connect = null;
        try {
            // 通过类加载机制来加载驱动类
            Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            Driver mysqlDriver = new Driver();
            // mysql8的时区问题，需要指定UTC时区
            String url = "jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC";
            Properties pro = new Properties();
            // 用户名和密码
            pro.setProperty("user", "root");
            pro.setProperty("password", "123");
            connect = mysqlDriver.connect(url, pro);
            System.out.println(connect);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(connect != null){
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test2()  {
        InputStream is = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            is = Test1.class.getClassLoader().getResourceAsStream("sql.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            //加载驱动
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            String sql = "insert into tb_user(id, user_name, password) values(?, ?, ?)";
            ps = connection.prepareStatement(sql);
            //填充占位符
            ps.setLong(1, 123);
            ps.setString(2, "wxx");
            ps.setString(3, "wxx");
            //执行
            ps.execute();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 使用工具类
     */
    @Test
    public void test3(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update tb_user set id = 133 where user_name = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, "wxx");
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(connection, ps);
    }

    /***
     * 查询操作
     */
    @Test
    public void test4(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from tb_user";
            ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()){
                long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(connection, ps);
    }

    @Test
    public void test5(){
        //插入二进制文件
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "insert into user values(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, "wangxu");
            ps.setObject(2, 111);
            ps.setObject(3, "beijing");
            InputStream is = Test1.class.getClassLoader().getResourceAsStream("1.jpg");
//            FileInputStream fis = new FileInputStream(new File("src/1.jpg"));
            ps.setBlob(4, is);
            ps.execute();
            //禁止自动提交
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            for(int i = 0; i < 20000; ++i){
                ps.setString(1, "name" + i);
                ps.setInt(2,  i);
                ps.setString(3, "addr" + i);

                ps.addBatch();
                if(i % 500 == 0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            //最后再提交
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000 + "秒") ;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
