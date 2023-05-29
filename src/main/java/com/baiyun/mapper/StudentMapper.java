package com.baiyun.mapper;

import com.baiyun.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student;")
    List<Student> selectAll();
    List<Student> selectALLdt(@Param("gid") String gid,@Param("cid")String cid, @Param("page") int page, @Param("rows") int rows);
    @Insert("insert into student (number, name, gender, phone, qq, cid, gid) values (#{number},#{name},#{gender},#{phone},#{qq},#{cid},#{gid});")
    int addStudent(Student student);
    @Update("update student set name = #{name},gender=#{gender},phone=#{phone},qq=#{qq},gid=#{gid},cid =#{cid} where number = #{number};")
    int updateStudent(Student student);
}
