package com.student.demo.controller;

import com.student.demo.Bean.Course;
import com.student.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminCourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/insert")
    public String insertCourse(@RequestParam("name")String name,
                               @RequestParam("teacher")String teacher,
                               @RequestParam("address")String address,
                               @RequestParam("time")String time){
        System.out.println(name);
        System.out.println(teacher);
        System.out.println(address);
        System.out.println(time);
        Course course = new Course();
        course.setName(name);
        course.setTeacher(teacher);
        course.setAddress(address);
        course.setTime(time);
        courseService.insertOne(course);
        return "redirect:/admin/index";
    }

    @PostMapping("/course/update")
    public String updateCourse(@RequestParam("id")Integer id,
                               @RequestParam("name")String name,
                               @RequestParam("teacher")String teacher,
                               @RequestParam("address")String address,
                               @RequestParam("time")String time){
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setTeacher(teacher);
        course.setAddress(address);
        course.setTime(time);
        courseService.updateOne(course);
        return "redirect:/admin/index";
    }

//    @RequestMapping("/course/delete")
//    public String updateCourse(@RequestParam("id")Integer id){
//        System.out.println(id);
//
//        return "redirect:/admin/index";
//    }
}
