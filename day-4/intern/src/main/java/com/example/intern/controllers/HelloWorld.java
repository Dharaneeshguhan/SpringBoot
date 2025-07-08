package com.example.intern.controllers;
import com.example.intern.models.Employee;
import com.example.intern.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorld {

    @Autowired
    private MyService myService;

    @PostMapping("/")
    public String postMethod() {
        return myService.postMethod();
    }

    @GetMapping("/")
    public String hello() {
        System.out.println("Hello world");
        return myService.getWelcomeMessage();
    }

    @PutMapping("/")
    public String putMethod() {
        return myService.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod() {
        return myService.deleteMethod();
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployees() {
        return myService.getAllEmployees();
    }

    @PostMapping("/emp")
    public String addEmployee(@RequestBody Employee emp) {
        myService.addEmployee(emp);
        return "Employee has been added successfully";
    }
}
