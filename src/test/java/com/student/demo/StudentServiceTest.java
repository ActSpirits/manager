package com.student.demo;

import com.student.demo.Bean.Student;
import com.student.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getOneById(){
        Student oneById = studentService.getOneById("1805110120");
        System.out.println(oneById);
    }
}
