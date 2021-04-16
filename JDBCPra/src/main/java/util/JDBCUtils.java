package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Mr.wxx
 * @create 2021-04-02-14:12
 **/
public class JDBCUtils {

    /***
     * 获取连接
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("sql.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //加载驱动
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /***
     * 关闭连接
     * @param conn
     * @param stat
     */
    public static void close(Connection conn, Statement stat){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(stat != null)
                stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
