package com.student.demo.controller;


import com.student.demo.Bean.Course;
import com.student.demo.Bean.Student;
import com.student.demo.mapper.CourseMapper;
import com.student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public ModelAndView adminIndexPage(){
        ModelAndView mv = new ModelAndView();
        List<Course> courseList = courseMapper.listAllCourse();
//        System.out.println(courseList);
        List<Student> studentList = studentService.listAllStudent();
//        System.out.println(studentList);
        for (Student student :studentList){
            System.out.println(student.getCourseList().size());
        }
        mv.addObject("courseList",courseList);
        mv.addObject("studentList",studentList);
        mv.setViewName("admin/adminIndex");
        return mv;
    }

}
