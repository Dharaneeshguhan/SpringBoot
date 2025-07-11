package com.example.Intern.controllers;
import com.example.Intern.models.RegisterDetails;
import com.example.Intern.models.Task;
import com.example.Intern.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String route() {
        return "Welcome to SpringBoot Security";
    }
    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getMethod() {
        return employeeService.getMethod();
    }
    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public RegisterDetails getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }
    @PostMapping("/employee")
    @PreAuthorize("hasRole('ADMIN')")
    public String postMethod(@RequestBody RegisterDetails employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateById(@PathVariable int empId, @RequestBody RegisterDetails employee) {
        return employeeService.updateEmployeeById(empId, employee);
    }
    @DeleteMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMethod(@PathVariable int empId) {
        return employeeService.deleteEmployeeById(empId);
    }
    @GetMapping("/employee/role/{roleName}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getEmployeesByRole(@PathVariable String roleName) {
        return employeeService.getEmployeesByRole(roleName);
    }
    @PostMapping("/employee/{empId}/assign-task")
    @PreAuthorize("hasRole('ADMIN')")
    public String assignTask(@PathVariable int empId, @RequestBody Task task) {
        return employeeService.assignTaskToEmployee(empId, task);
    }
    @GetMapping("/employee/{empId}/tasks")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Task> getEmployeeTasks(@PathVariable int empId) {
        return employeeService.getTasksByEmployee(empId);
    }
}
