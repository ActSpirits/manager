package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassMapper extends BaseMapper<Class> {

    @Select("select * from t_class where id = #{id}")
    @Results(id = "classMap1",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "time",column = "time"),
            @Result(property = "studentList",column = "id",many = @Many(select = "com.student.demo.mapper.StudentMapper.listByClassId"))
    })
    public Class getOneById(@Param("id") Integer id);

    @Select("select * from t_class where id = (select classId from t_student where id = #{studentId})")
    @ResultMap("classMap1")
    public Class getOneByStudentId(@Param("studentId")Integer studentId);


    @Select("select * from t_class")
    @ResultMap("classMap1")
    public List<Class> listAllClass();
}
