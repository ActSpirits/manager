package com.student.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.demo.Bean.Class;
import org.apache.ibatis.annotations.*;

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


}
