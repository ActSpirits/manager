package com.student.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.demo.Bean.Course;
import com.student.demo.mapper.CourseMapper;
import com.student.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> listAllCourse() {
        return courseMapper.listAllCourse();
    }
}
