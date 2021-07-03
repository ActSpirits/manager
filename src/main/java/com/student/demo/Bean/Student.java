package com.student.demo.Bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@TableName("t_student")
public class Student {
    private String id;
    private String name;
    private Integer age;
    private Class itsClass;
    private String password;
    private List<Grade> gradeList;
    private List<Course> courseList;
}
