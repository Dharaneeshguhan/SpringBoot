package com.example.Springbootfirstproject.controller;

import com.example.Springbootfirstproject.Models.Employee;
import com.example.Springbootfirstproject.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class HelloWorldController {
    @Autowired
    HelloWorldService hwshelloWorldServiece;
    @GetMapping("/emp")
    public List<Employee> emp(){
        return helloWorldServiece.getAllEmployees();
    }
    @PostMapping("/emp")
    public void setvalues(@RequestBody Employee emp){
        helloWorldServiece.setvalues(emp);
    }
    @GetMapping("/hello")
    public String gethello(){
        return helloWorldServiece.gethello();
    }
    @PostMapping("/hello")
    public String postHello(){
        return helloWorldServiece.postHello();
    }
    @PutMapping("/hello")
    public String putHello(){
        return helloWorldServiece.putHello();
    }
    @DeleteMapping("/hello")
    public String deleteHello(){
        return helloWorldServiece.deleteHello();
    }
}
