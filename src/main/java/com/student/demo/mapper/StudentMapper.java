package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from t_student where id = #{id}")
    @Results(id = "studentMap1",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age"),
            @Result(property = "classId",column = "classId"),
            @Result(property = "password",column = "password"),
            @Result(property = "gradeList",column = "id",many = @Many(select = "com.student.demo.mapper.GradeMapper.listByStudentId")),
            @Result(property = "courseList",column = "id",many = @Many(select = "com.student.demo.mapper.CourseMapper.listByStudentId")),
    })
    public Student getOneById(@Param("id") String id);

    @Select("select * from t_student where classId = #{classId}")
    public List<Student> listByClassId(@Param("classId")Integer id);
}
