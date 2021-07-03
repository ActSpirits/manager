package com.student.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.demo.Bean.Grade;
import com.student.demo.Bean.Student;
import com.student.demo.mapper.GradeMapper;
import com.student.demo.mapper.StudentMapper;
import com.student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;


    @Override
    public Student getOneById(String id) {
        return studentMapper.getOneById(id);
    }

    @Override
    public List<Student> listAllStudent() {
        return studentMapper.listAllStudent();
    }

    @Override
    public void insertOne(Student student) {
        studentMapper.insertOne(student.getId(),student.getName(),student.getAge(),student.getClassId(),student.getPassword());
    }

    @Override
    public void deleteOne(String id) {
        gradeMapper.deleteByStudentId(id);
        studentMapper.deleteStudent_CourseByStudentId(id);
        studentMapper.deleteOne(id);
    }

    @Override
    public void updateOne(Student student) {
        studentMapper.updateOne(student.getId(),student.getName(),student.getAge(),student.getClassId(),student.getPassword());
    }

    @Override
    public void selectCourse(String id, Integer id1) {
        studentMapper.selectCourse(id,id1);
    }

    @Override
    public void disSelectCourse(String id, Integer id1) {
        studentMapper.disSelectCourse(id,id1);
    }
}
