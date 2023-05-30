package com.baiyun.mapper;

import com.baiyun.entity.Clazz;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClazzMapper {
    List<Clazz>selectAlldt(String gid);



    @Select("select * from clazz limit #{page},#{row}")
    List<Clazz>selectAllByPageAndRow(@Param("page") int page,@Param("row") int row);
}
