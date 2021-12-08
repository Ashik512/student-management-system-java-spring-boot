package com.practice.studentmanagementsystem.service.impl;

import com.practice.studentmanagementsystem.entity.Student;
import com.practice.studentmanagementsystem.repository.StudentRepository;
import com.practice.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        //super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
