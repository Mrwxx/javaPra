package com.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mp.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.wxx
 * @create 2021-06-30-14:13
 **/
@Mapper
public interface MyMapper extends BaseMapper<User> {

    //自定义sql
    @Insert("select * from ${tableName}")
    public User selectOne(@Param("tableName") String tableName, @Param("name")String name);
}





