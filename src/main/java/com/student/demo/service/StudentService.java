package com.student.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.student.demo.Bean.Student;

public interface StudentService extends IService<Student> {

    public Student getOneById(String id);
}
