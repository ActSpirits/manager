package com.student.demo.controller;

import com.student.demo.Bean.Admin;
import com.student.demo.Bean.Class;
import com.student.demo.Bean.Student;
import com.student.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/")
    public ModelAndView loginPage(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/admin/admin");
        return mv;
    }

    @PostMapping("/")
    public String login(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              HttpServletRequest request){
        Admin adminByUsername = adminService.getAdminByUsername(username);
        if (adminByUsername != null && adminByUsername.getPassword().equals(password)){
            request.getSession().setAttribute("admin",adminByUsername);
            request.getSession().removeAttribute("msg");
            return "redirect:/admin/index";
        }
        else {
            request.getSession().setAttribute("msg","用户名或密码错误！");
            return "redirect:/admin";
        }
    }
}
