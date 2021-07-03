package com.student.demo.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.demo.Bean.Class;
import com.student.demo.Bean.Course;
import com.student.demo.Bean.Student;
import com.student.demo.mapper.CourseMapper;
import com.student.demo.service.ClassService;
import com.student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminIndexController {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @GetMapping("/index")
    public ModelAndView adminIndexPage(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,4);
        List<Student> studentList = studentService.listAllStudent();
        PageInfo<Student> studentPageInfo = new PageInfo<Student>(studentList);
        System.out.println(studentPageInfo);
        List<Course> courseList = courseMapper.listAllCourse();
        List<Class> classList = classService.listAllClass();
        ModelAndView mv = new ModelAndView();
        mv.addObject("courseList",courseList);
        mv.addObject("studentPageInfo",studentPageInfo);
        mv.addObject("studentList",studentList);
        mv.addObject("classList",classList);
        mv.setViewName("admin/adminIndex");
        return mv;
    }

}
