package com.example.intern.service;
import com.example.intern.models.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyService {

    List<Employee> empList = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Prasanth", "Trainer"),
                    new Employee(2, "Yuvaraj", "Faculty")
            )
    );

    public String postMethod() {
        return "Post method has buzzed successfully";
    }

    public String getWelcomeMessage() {
        return "Get method has buzzed successfully";
    }

    public String putMethod() {
        return "Put method buzzed successfully";
    }

    public String deleteMethod() {
        return "Delete method buzzed successfully";
    }

    public List<Employee> getAllEmployees() {
        return empList;
    }

    public void addEmployee(Employee emp) {
        empList.add(emp);
    }
}
