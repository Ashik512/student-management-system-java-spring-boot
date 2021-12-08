package com.practice.studentmanagementsystem.repository;

import com.practice.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
