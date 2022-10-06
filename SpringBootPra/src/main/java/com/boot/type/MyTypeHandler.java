package com.boot.type;

import com.boot.pojo.StreamLine;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Mr.wxx
 * @create 2021-06-28-23:56
 **/
public class MyTypeHandler implements TypeHandler<StreamLine> {
    @Override
    public void setParameter(PreparedStatement ps, int i, StreamLine parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public StreamLine getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public StreamLine getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public StreamLine getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
