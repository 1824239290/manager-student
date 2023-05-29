package com.baiyun.mapper;

import com.baiyun.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student;")
    List<Student> selectAll();
    List<Student> selectALLdt(@Param("gid") String gid,@Param("cid")String cid, @Param("page") int page, @Param("rows") int rows);
}
