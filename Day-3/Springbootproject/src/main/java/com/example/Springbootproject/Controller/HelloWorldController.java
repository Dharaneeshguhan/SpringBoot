package com.example.Springbootproject.Controller;
import com.example.Springbootfirstproject.Models.Employee;
import com.example.Springbootfirstproject.Models.Student;
import com.example.Springbootfirstproject.Services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService sws;
    @GetMapping("/home")
    public String hello()
    {
        return sws.hello();
    }
    @PostMapping("/home")
    public String postHello()
    {
        return sws.postHello();
    }
    @PutMapping("/home")
    public String PutMapping()
    {
        return sws.PutMapping();
    }
    @DeleteMapping("/home")
    public String DeleteMapping()
    {
        return  sws.Deletemapping();
    }
    @PostMapping("/")
    public void SetArrayListvalues(@RequestBody Employee emp)
    {
        sws.Setvalues(emp);
    }
    @GetMapping("/")
    public ArrayList<Employee> emp()
    {
        return sws.getEmp();
    }
    @GetMapping("/Student")
    public ArrayList<Student>getStudent()
    {
        return sws.getAllStudent();
    }
    @PutMapping("/")
    public void ChangeEmployee(@RequestBody List< Employee> emp)
    {
        sws.ChnageDetails(emp);
    }
    @DeleteMapping("/")
    public void DeleteEmployee(@RequestBody  Employee emp)
    {
        sws.DeleteEmployee(emp);
    }
}
