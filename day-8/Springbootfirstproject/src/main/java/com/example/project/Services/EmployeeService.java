package com.example.project.Services;

import com.example.project.Models.Employee;
import com.example.project.Repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo  employeeRepo;


    public List<Employee> getMethod() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepo.findById(empId).orElse(new Employee());
    }

    public String addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployee(int empId) {
        Employee user = employeeRepo.findById(empId)
                .orElseThrow(()->new RuntimeException("No Such User Present"));
        employeeRepo.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID) {
        employeeRepo.deleteById(empID);
        return "Employee Deleted Successfully";
    }


    public List<Employee >getByRole(String role) {
        return employeeRepo.findByRoles_RoleName(role);
    }

    public void updatebyId(int id, Employee employee) {
        Employee user = employeeRepo.findById(id).orElseThrow();
        user.setName(employee.getName());
        user.setEmail(employee.getEmail());
        user.setUserName(employee.getUserName());
        user.setPassword(employee.getPassword());
         employeeRepo.save(user);

    }
}
