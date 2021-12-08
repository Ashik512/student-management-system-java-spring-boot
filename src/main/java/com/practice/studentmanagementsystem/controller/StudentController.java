package com.practice.studentmanagementsystem.controller;

import com.practice.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
   private StudentService studentService;

    public StudentController(StudentService studentService) {
        //super();
        //this.studentService = studentService;
    }

    /** method for getting all students info and return model and data to view **/
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

}
