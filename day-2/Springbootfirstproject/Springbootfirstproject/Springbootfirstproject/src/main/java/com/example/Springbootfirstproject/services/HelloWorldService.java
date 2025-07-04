package com.example.Springbootfirstproject.services;

import com.example.Springbootfirstproject.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> e=new ArrayList<>(
            Arrays.asList(new Employee(1,"SUMO","Trainer",250),new Employee(2,"Chennimalai","Trainer",150))
    );
    public List<Employee> getAllEmployees() {
        return e;
    }
    public void setvalues(Employee emp) {
        e.add(emp);
    }

    public String gethello(){
        return "Hello World";
    }
    public String postHello(){
        return "Hello from post";
    }
    public String deleteHello(){
        return "Hello from delete";
    }
    public String putHello(){
        return "Hello from put";
    }
}
