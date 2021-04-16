package util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author Mr.wxx
 * @create 2021-04-02-15:31
 **/
public class GenericSql {

    /***
     * 通用的查询数据表方法，并创建对应的POJO对象，使用反射技术
     * @param tClass
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T query(Class<T> tClass,String sql, Object... args){
        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            //ps中参数复制
            for(int i = 0 ; i < args.length; ++i){
                ps.setObject(i+1, args[i]);
            }
            //ps执行
            ResultSet resultSet = ps.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列的数量
            int columnCount = metaData.getColumnCount();
            if(resultSet.next()){
                // 创建一个新的对象
                T t = tClass.newInstance();
                //对于每一条记录遍历
                for(int i = 0; i < columnCount; ++i){
                    //每一列的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //列的值
                    Object object = resultSet.getObject(i + 1);
                    //每POJO填充参数
                    Field declaredField = tClass.getDeclaredField(columnLabel);
                    //赋予权限
                    declaredField.setAccessible(true);
                    declaredField.set(t, object);
                }
                return t;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
