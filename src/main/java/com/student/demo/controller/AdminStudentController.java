package com.student.demo.controller;

import com.student.demo.Bean.Student;
import com.student.demo.service.GradeService;
import com.student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminStudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @PostMapping("/student/insert")
    public String insertStudent(@RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("age") Integer age,
                                @RequestParam("classId") Integer classId,
                                @RequestParam("password") String password) {
        Student oneById = studentService.getOneById(id);
        if (oneById != null) {
            return "redirect:/admin/index";
        } else {
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setClassId(classId);
            student.setPassword(password);
            studentService.insertOne(student);
        }
        return "redirect:/admin/index";
    }

    @RequestMapping("/student/delete")
    public String deleteStudent(@RequestParam("id") String id) {
        studentService.deleteOne(id);
        return "redirect:/admin/index";
    }

    @PostMapping("/student/update")
    public String updateStudent(@RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("age") Integer age,
                                @RequestParam("classId") Integer classId,
                                @RequestParam("password") String password) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setClassId(classId);
        student.setPassword(password);
        studentService.updateOne(student);
        return "redirect:/admin/index";
    }


}
