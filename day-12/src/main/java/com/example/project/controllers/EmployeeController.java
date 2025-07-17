package com.example.project.controllers;
import com.example.project.models.RegisterDetails;
import com.example.project.models.UserDetailsDto;
import com.example.project.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/")
    public String  hello(){
        return "Spring security";
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    @GetMapping("/emp")
    public List<RegisterDetails> getMethod() {
        return employeeService.getMethod();
    }
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/emp/id/{id}")
    public RegisterDetails getEmployeeById(@PathVariable int id) {

        return employeeService.getEmployeeById(id);
    }
        @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/emp/job/{job}")
    public List<RegisterDetails> getEmployeeByJob(@PathVariable String job) {

        return employeeService.getEmployeeByJob(job);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/emp/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody UserDetailsDto employee) {
        return employeeService.updateEmployee( id,employee);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/emp/{id}")
    public String deleteMethod(@PathVariable int id) {
        return employeeService.deleteMethod(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/emp/roles/{role}")
    public List<RegisterDetails> getbyroles(@PathVariable String role) {
        return employeeService.getbyroles(role);
    }
}