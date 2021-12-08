package com.practice.studentmanagementsystem.controller;

import com.practice.studentmanagementsystem.entity.Student;
import com.practice.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
   private StudentService studentService;

    public StudentController(StudentService studentService) {
        //super();
       this.studentService = studentService;
    }

    /** method for getting all students info and return model and data to view **/
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

   /** code for showing adding student form **/
   @GetMapping("/students/add")
   public String createStudentForm(Model model){

       // student object for holding student form data
       Student student = new Student();
       model.addAttribute("student", student);

       return "create_student";
   }
   //Saving students data
   @PostMapping("/students")
   public String saveStudents(@ModelAttribute("students") Student student){
       studentService.saveStudent(student);
       return "redirect:/students";
   }

   //Showing add students form
   @GetMapping("/students/edit/{id}")
    public String studentEditForm(@PathVariable Long id, Model model){
       model.addAttribute("student", studentService.getStudentById(id));
       return "edit_student";
   }

   //Updating students data
   @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){

       //getting student by id from database
       Student existingStudent = studentService.getStudentById(id);

       existingStudent.setId(id);
       existingStudent.setFirstName(student.getFirstName());
       existingStudent.setLastName(student.getLastName());
       existingStudent.setEmail(student.getEmail());

       //updating student
       studentService.updateStudent(existingStudent);

       return "redirect:/students";
   }

   //deleting students data
   @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id){
       studentService.deleteStudentById(id);
       return "redirect:/students";
   }

}
