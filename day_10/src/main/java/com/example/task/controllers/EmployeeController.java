package com.example.task.controllers;
import com.example.task.models.RegisterDetails;
import com.example.task.models.UserDetailsDto;
import com.example.task.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String route(){
        return "Welcome to SpringBoot Security";
    }


    @GetMapping("/employee")

    public List<RegisterDetails> getMethod(){
        return employeeService.getMethod();
    }


    @GetMapping("/employee/{empId}")

    public RegisterDetails getEmployeeById(@PathVariable int empId){
        System.out.println();
        return employeeService.getEmployeeById(empId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody RegisterDetails employee){
        return employeeService.addEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/employee/{empId}")
    public String putMethod(@PathVariable int empId){
        return employeeService.updateEmployee(empId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/employee/{empID}")
    public String deleteMethod(@PathVariable int empID){
        return employeeService.deleteEmployeeById(empID);
    }
}
