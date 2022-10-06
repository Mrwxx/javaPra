package com.boot.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author Mr.wxx
 * @create 2021-06-28-22:35
 **/
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
