package com.student.demo.controller;

import com.student.demo.Bean.Course;
import com.student.demo.Bean.Curriculum;
import com.student.demo.Bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView indexPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Student loginStudent = (Student)request.getSession().getAttribute("loginStudent");
        Curriculum curriculum1 = new Curriculum();
        System.out.println(loginStudent);
        System.out.println(loginStudent.getCourseList());
        System.out.println(loginStudent.getGradeList());
        Curriculum curriculum = getCurriculum(curriculum1, loginStudent.getCourseList());
        mv.addObject("loginStudent",loginStudent);
        mv.addObject("curriculum",curriculum);
        mv.setViewName("logined/index");
        return mv;
    }

    public Curriculum getCurriculum(Curriculum curriculum, List<Course> courseList){
        for (Course course :courseList){
            switch (course.getTime()){
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
