package com.student.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.demo.Bean.Student;
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

    @Override
    public Student getOneById(String id) {
        return studentMapper.getOneById(id);
    }

    @Override
    public List<Student> listAllStudent() {
        return studentMapper.listAllStudent();
    }
}
