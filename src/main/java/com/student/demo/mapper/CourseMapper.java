package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Select("select * from t_course where id in (select courseId from t_student_course where studentId = #{studentId})")
    public List<Course> listByStudentId(@Param("studentId")String studentId);

    @Select("select * from t_course where id = (select courseId from t_grade where id = #{gradeId})")
    public Course getCourseByGradeId(@Param("gradeId")Integer gradeId);

    @Select("select * from t_course")
    @Results(id = "courseMap1",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "teacher",column = "teacher"),
            @Result(property = "address",column = "address"),
            @Result(property = "time",column = "time"),
            @Result(property = "studentList",column = "id",many = @Many(select = "com.student.demo.mapper.StudentMapper.listByCourseId"))
    })
    public List<Course> listAllCourse();

    @Insert("insert into t_course (name,teacher,address,time) values (#{name},#{teacher},#{address},#{time})")
    public void insertOne(@Param("name") String name,@Param("teacher") String teacher,@Param("address") String address,@Param("time") String time);

    @Update("update t_course set name = #{name} , teacher = #{teacher} , address = #{address} , time = #{time} where id = #{id}")
    public void updateOne(@Param("id") Integer id,@Param("name") String name,@Param("teacher") String teacher,@Param("address") String address,@Param("time") String time);

    @Select("select * from t_course where id = #{id}")
    public Course getOneById(@Param("id") Integer id);
}
