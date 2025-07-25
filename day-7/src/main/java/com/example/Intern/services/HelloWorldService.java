package com.example.Intern.services;
import com.example.Intern.models.Employee;
import com.example.Intern.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class HelloWorldService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee addEmployee(String name, String role) {
        Employee e = new Employee();
        e.setName(name);
        e.setRole(role);
        return employeeRepository.save(e);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int eid){
        Optional<Employee> employee = employeeRepository.findById(eid);
        return employee.orElse(null);
    }

    public Employee getEmployeeByJob(String job){
        return employeeRepository.findByJob(job);
    }

    public String deleteEmployeeById(int eid) {
        if(employeeRepository.existsById(eid)){
            employeeRepository.deleteById(eid);
            return "EMPLOYEE DELETED SUCCESSFULLY";
        }
        else{
            return "Employee not found";
        }
    }

    public String deleteAllEmployee(){
        if(!employeeRepository.findAll().isEmpty()){
            employeeRepository.deleteAll();
            return "Employee data deleted Successfully";
        }
        else{
            return "Employee data is empty";
        }
    }

    public String updateRecord(Employee employee){
        if(employeeRepository.existsById(employee.getEid())){
            employeeRepository.save(employee);
            return "Employee updated Successfully";
        }
        else{
            return "Employee not found";
        }
    }
}