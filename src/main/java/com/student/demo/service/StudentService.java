package com.student.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.student.demo.Bean.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    public Student getOneById(String id);

    public List<Student> listAllStudent();

    public void insertOne(Student student);

    public void deleteOne(String id);

    public void updateOne(Student student);
}
