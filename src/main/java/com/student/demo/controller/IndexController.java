package com.student.demo.controller;

import com.student.demo.Bean.Course;
import com.student.demo.Bean.Curriculum;
import com.student.demo.Bean.Student;
import com.student.demo.service.CourseService;
import com.student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public ModelAndView indexPage(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Student studentById = studentService.getOneById(loginStudent.getId());
        Curriculum curriculum1 = new Curriculum();
        List<Course> courseList = courseService.listAllCourse();
//        for (Course course:courseList){
//            System.out.println(course);
//        }
        Curriculum curriculum = getCurriculum(curriculum1, studentById.getCourseList());
        mv.addObject("loginStudent", studentById);
        mv.addObject("curriculum", curriculum);
        mv.addObject("courseList", courseList);
        request.getSession().setAttribute("loginStudent",studentById);
        mv.setViewName("logined/index");
        return mv;
    }

    @RequestMapping("/selectCourse")
    public String selectCourse(@RequestParam("id") Integer id,
                               HttpServletRequest request) {
        System.out.println(id);
        //查出来
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Student studentById = studentService.getOneById(loginStudent.getId());
        Curriculum curriculum = getCurriculum(new Curriculum(), studentById.getCourseList());
        Course course = courseService.getOneById(id);
        for (Course course1 : studentById.getCourseList()) {
            if (course1.getTime().equals(course.getTime())) {
                return "redirect:/index";
            }
        }
        studentService.selectCourse(loginStudent.getId(),id);
        request.getSession().setAttribute("loginStudent",studentById);
        return "redirect:/index";

    }
    @RequestMapping("/disSelectCourse")
    public String disSelectCourse(@RequestParam("id") Integer id,
                               HttpServletRequest request) {
        System.out.println(id);
        //查出来
        Student loginStudent = (Student) request.getSession().getAttribute("loginStudent");
        Student studentById = studentService.getOneById(loginStudent.getId());
        studentService.disSelectCourse(studentById.getId(),id);
        Student studentById1 = studentService.getOneById(loginStudent.getId());
        request.getSession().setAttribute("loginStudent",studentById1);
        return "redirect:/index";

    }

    public Curriculum getCurriculum(Curriculum curriculum, List<Course> courseList) {
        for (Course course : courseList) {
            switch (course.getTime()) {
                case "每周一上午一二节":
                    curriculum.setMMOAT(course.getName());
                    break;
                case "每周一上午三四节":
                    curriculum.setMMTAF(course.getName());
                    break;
                case "每周一下午一二节":
                    curriculum.setMAOAT(course.getName());
                    break;
                case "每周一下午三四节":
                    curriculum.setMATAF(course.getName());
                    break;
                case "每周二上午一二节":
                    curriculum.setTMOAT(course.getName());
                    break;
                case "每周二上午三四节":
                    curriculum.setTMTAF(course.getName());
                    break;
                case "每周二下午一二节":
                    curriculum.setTAOAT(course.getName());
                    break;
                case "每周二下午三四节":
                    curriculum.setTATAF(course.getName());
                    break;
                case "每周三上午一二节":
                    curriculum.setWMOAT(course.getName());
                    break;
                case "每周三上午三四节":
                    curriculum.setWMTAF(course.getName());
                    break;
                case "每周三下午一二节":
                    curriculum.setWAOAT(course.getName());
                    break;
                case "每周三下午三四节":
                    curriculum.setWATAF(course.getName());
                    break;
                case "每周四上午一二节":
                    curriculum.setTHMOAT(course.getName());
                    break;
                case "每周四上午三四节":
                    curriculum.setTHMTAF(course.getName());
                    break;
                case "每周四下午一二节":
                    curriculum.setTHAOAT(course.getName());
                    break;
                case "每周四下午三四节":
                    curriculum.setTHATAF(course.getName());
                    break;
                case "每周五上午一二节":
                    curriculum.setFMOAT(course.getName());
                    break;
                case "每周五上午三四节":
                    curriculum.setFMTAF(course.getName());
                    break;
                case "每周五下午一二节":
                    curriculum.setFAOAT(course.getName());
                    break;
                case "每周五下午三四节":
                    curriculum.setFATAF(course.getName());
                    break;
                case "每周六上午一二节":
                    curriculum.setSMOAT(course.getName());
                    break;
                case "每周六上午三四节":
                    curriculum.setSMTAF(course.getName());
                    break;
                case "每周六下午一二节":
                    curriculum.setSAOAT(course.getName());
                    break;
                case "每周六下午三四节":
                    curriculum.setSATAF(course.getName());
                    break;
                case "每周日上午一二节":
                    curriculum.setSOMOAT(course.getName());
                    break;
                case "每周日上午三四节":
                    curriculum.setSOMTAF(course.getName());
                    break;
                case "每周日下午一二节":
                    curriculum.setSOAOAT(course.getName());
                    break;
                case "每周日下午三四节":
                    curriculum.setSOATAF(course.getName());
                    break;
            }
        }
        return curriculum;
    }
}
