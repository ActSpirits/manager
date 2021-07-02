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
@TableName("t_course")
public class Course {
    private Integer id;
    private String name;
    private String teacher;
    private String address;
    private String time;
    private List<Student> studentList;
    private List<Grade> gradeList;
}
