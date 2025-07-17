//package com.example.project.controllers;
//
//import com.example.project.models.EmployeeTask;
//import com.example.project.services.EmployeeTaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tasks")
//public class EmployeeTaskController {
//
//    @Autowired
//    private EmployeeTaskService taskService;
//
//    @PostMapping("/employee/{employeeId}")
//    public String createTask(@PathVariable int employeeId, @RequestBody EmployeeTask task) {
//        return taskService.createTask(employeeId, task);
//    }
//}