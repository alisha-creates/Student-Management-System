package com.example.student_management.service;

import com.example.student_management.model.Student;
import com.example.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<Student> getStudents() {
        return repository.getStudents();
    }

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public Student getStudent(int id) {
        return repository.getStudent(id);
    }

    public String updateStudent(int id, Student student) {
        for(Student s : repository.getStudents()){
            if(s.getId() == id){
                s.setName(student.getName());
                return "Student Updated";
            }
        }
        return "Student Not Found";
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}
