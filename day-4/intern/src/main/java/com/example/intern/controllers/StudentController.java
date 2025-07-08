package com.example.intern.controllers;
import com.example.intern.models.Student;
import com.example.intern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public String postMethod() {
        return studentService.postMethod();
    }

    @GetMapping("/")
    public String hello() {
        System.out.println("Hello student world");
        return studentService.getWelcomeMessage();
    }

    @PutMapping("/")
    public String putMethod() {
        return studentService.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod() {
        return studentService.deleteMethod();
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/new")
    public String addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return "Student has been added successfully";
    }
}
