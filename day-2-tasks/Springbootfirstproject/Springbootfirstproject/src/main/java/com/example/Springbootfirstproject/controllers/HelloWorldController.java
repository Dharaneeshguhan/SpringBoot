package com.example.Springbootfirstproject.controllers;

import com.example.Springbootfirstproject.models.Employee;
import com.example.Springbootfirstproject.models.Student;
import com.example.Springbootfirstproject.serviece.HelloWorldServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController
{
    @Autowired
    HelloWorldServiece  helloWorldServiece;

    @GetMapping("/home")
    public String hello()
    {
        return helloWorldServiece.get();
    }

    @PostMapping("/home")
    public String postMethod()
    {
        return helloWorldServiece.post();
    }

    @PutMapping("/home")
    public String putMethod()
    {
        return helloWorldServiece.put();
    }

    @DeleteMapping("/home")
    public String deleteMethod()
    {
        return helloWorldServiece.del();
    }

    @GetMapping("/emp")
    public ArrayList<Employee> emp(){
        return helloWorldServiece.getallEmp();
    }

    @PostMapping("/emp")
    public void setarray(@RequestBody Employee emp)
    {
        helloWorldServiece.setvalue(emp);
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmp(@PathVariable int id) {
        helloWorldServiece.deleteEmpById(id);
    }

    @PutMapping("/emp/{id}")
    public void updateEmp(@PathVariable int id, @RequestBody Employee updatedEmp) {
        helloWorldServiece.updateEmp(id, updatedEmp);
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable int id) {
        return helloWorldServiece.getEmpById(id);
    }

    @GetMapping("/std/{rol}")
    public Student getStudentByRoll(@PathVariable int rol) {
        return helloWorldServiece.getStudentByRoll(rol);
    }

    @GetMapping("/std")
    public List<Student> std()
    {
        return helloWorldServiece.getStudents();
    }

    @PostMapping("/std")
    public void setstudent(@RequestBody Student std)
    {
        helloWorldServiece.setStudents(std);
    }

    @DeleteMapping("/std/{rol}")
    public void deleteStudent(@PathVariable int rol) {
        helloWorldServiece.deleteStudentByRoll(rol);
    }

    @PutMapping("/std/{rol}")
    public void updateStudent(@PathVariable int rol, @RequestBody Student updatedStd) {
        helloWorldServiece.updateStudent(rol, updatedStd);
    }
}
