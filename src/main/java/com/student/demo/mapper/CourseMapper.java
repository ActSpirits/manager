package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Select("select * from t_course where id in (select courseId from t_student_course where studentId = #{studentId})")
    public List<Course> listByStudentId(@Param("studentId")String studentId);

    @Select("select * from t_course where id = (select courseId from t_grade where id = #{gradeId})")
    public Course getCourseByGradeId(@Param("gradeId")Integer gradeId);
}
