package com.baiyun.mapper;

import com.baiyun.entity.Grade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GradeMapper {
    @Select("select * from grade limit #{page},#{size}")
    List<Grade> selectGradeList(@Param("page") int page, @Param("size") int size);
    @Select("select * from grade;")
    List<Grade> selectAll();
    @Insert("insert into grade (gradeName) values (gradeName);")
    int insertGrade(String grade);
}
