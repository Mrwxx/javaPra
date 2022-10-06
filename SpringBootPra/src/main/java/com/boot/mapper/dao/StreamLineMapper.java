package com.boot.mapper.dao;

import com.boot.mapper.TkMapper;
import com.boot.pojo.StreamLine;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-06-28-22:49
 **/

@Repository
public interface StreamLineMapper extends TkMapper<StreamLine> {

    @Select({"select * from stream_line #{name}"})
    List<StreamLine> getAll(String name);
}
