package com.student.demo.controller;

import com.student.demo.Bean.Class;
import com.student.demo.Bean.Course;
import com.student.demo.Bean.Grade;
import com.student.demo.Bean.Student;
import com.student.demo.service.ClassService;
import com.student.demo.service.CourseService;
import com.student.demo.service.GradeService;
import com.student.demo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private ClassService classService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public ModelAndView loginPage(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/")
    public String login(@RequestParam("studentId")String studentId,
                              @RequestParam("password")String password,
                              HttpServletRequest request){
        ModelAndView mv =new ModelAndView();
        Student studentById = studentService.getOneById(studentId);
        if (studentById != null && studentById.getPassword().equals(password)){
            Class classById = classService.getOneById(studentById.getClassId());
            studentById.setItsClass(classById);
            request.getSession().setAttribute("loginStudent",studentById);
            request.getSession().removeAttribute("msg");
            return "redirect:/index";
        }
        else {
            request.getSession().setAttribute("msg","用户名或密码错误！");
            return "redirect:/";
        }
    }
}
