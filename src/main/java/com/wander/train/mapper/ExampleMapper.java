package com.wander.train.mapper;

import com.wander.train.pojo.Example;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * example数据库操作
 *
 * @author admin 2020/12/23/ 14:30
 */

@Mapper
public interface ExampleMapper {

    /**
     * 通过id查询example
     * @param id
     * @return
     */
    Example getById(@Param("id") int id);
}
