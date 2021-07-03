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
            @Result(property = "itsClass",column = "id",one = @One(select = "com.student.demo.mapper.ClassMapper.getOneByStudentId")),
            @Result(property = "password",column = "password"),
            @Result(property = "gradeList",column = "id",many = @Many(select = "com.student.demo.mapper.GradeMapper.listByStudentId")),
            @Result(property = "courseList",column = "id",many = @Many(select = "com.student.demo.mapper.CourseMapper.listByStudentId")),
    })
    public Student getOneById(@Param("id") String id);

    @Select("select * from t_student where classId = #{classId}")
    public List<Student> listByClassId(@Param("classId")Integer id);

    @Select("select * from t_student where id in (select studentId from t_student_course where courseId = #{courseId})")
    public List<Student> listByCourseId(@Param("courseId")Integer courseId);

    @Select("select * from t_student")
    @ResultMap("studentMap1")
    public List<Student> listAllStudent();

    @Insert("insert into t_student(id,name,age,classId,password) values (#{id},#{name},#{age},#{classId},#{password})")
    public void insertOne(@Param("id") String id,@Param("name") String name,@Param("age") Integer age,@Param("classId") Integer classId,@Param("password") String password);

    @Delete("delete from t_student_course where studentId = #{id}")
    public void deleteStudent_CourseByStudentId(@Param("id") String id);

    @Delete("delete from t_student where id = #{id}")
    public void deleteOne(@Param("id") String id);

    @Update("update t_student set name = #{name},age = #{age},classId = #{classId}, password = #{password} where id = #{id}")
    public void updateOne(@Param("id") String id,@Param("name") String name,@Param("age") Integer age,@Param("classId") Integer classId,@Param("password") String password);

    @Insert("insert into t_student_course (studentId,courseId) value (#{studentId},#{courseId})")
    public void selectCourse(@Param("studentId") String id,@Param("courseId") Integer id1);

    @Delete("delete from t_student_course where studentId = #{studentId} and courseId = #{courseId} ")
    public void disSelectCourse(@Param("studentId") String id,@Param("courseId") Integer id1);
}
