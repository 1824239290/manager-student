package com.baiyun.dao;


import com.baiyun.entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeachers() throws SQLException, ClassNotFoundException;

    Teacher getTeacherByNumber(String number) throws ClassNotFoundException, SQLException;

    int addTeacher(String number,String name,String gender,String phone,String qq) throws ClassNotFoundException, SQLException;

    int delete(String ids[]);
}
