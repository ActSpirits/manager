package com.student.demo.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.demo.Bean.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CourseService extends IService<Course> {

    public List<Course> listAllCourse();

    public void insertOne(Course course);

    public void updateOne(Course course);

    public Course getOneById(Integer id);
}
