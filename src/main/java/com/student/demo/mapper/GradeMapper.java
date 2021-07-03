package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Grade;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {

    @Select("select * from t_grade where studentId = #{studentId}")
    @Results(id = "gradeGrade1",value = {
            @Result(id =true,column = "id",property = "id"),
            @Result(column = "grade",property = "grade"),
            @Result(column = "time",property = "time"),
            @Result(column = "id",property = "course",one = @One(select = "com.student.demo.mapper.CourseMapper.getCourseByGradeId"))
    })
    public List<Grade> listByStudentId(@Param("studentId")String studentId);

    @Delete("delete from t_grade where studentId = #{id}")
    public void deleteByStudentId(@Param("id") String id);
}
