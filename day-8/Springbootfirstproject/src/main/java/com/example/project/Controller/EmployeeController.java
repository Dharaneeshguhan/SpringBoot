package com.example.project.Controller;
import com.example.project.Models.Employee;
import com.example.project.Services.EmployeeService;
import com.example.project.Services.HelloWorldService;
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
    public String route(){
        return "Welcome to SpringBoot Security";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Employee> getMethod(){
        return employeeService.getMethod();
    }

    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Employee getEmployeeById(@PathVariable int empId){
        System.out.println();
        return employeeService.getEmployeeById(empId);
    }
    @PutMapping("/employee/id/{Id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public void  updateEmployee(@PathVariable int Id,@RequestBody Employee employee){
         employeeService.updatebyId(Id,employee);
    }

    @GetMapping("/employee/role/{role}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Employee> getEmployeeByRole(@PathVariable String role){
        return employeeService.getByRole(role);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/employee")
    public String postMethod(@RequestBody Employee employee){
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


