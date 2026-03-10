package com.example.student_management.controller;

import com.example.student_management.model.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student Added";
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudent(id);
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student Deleted";
    }
}
