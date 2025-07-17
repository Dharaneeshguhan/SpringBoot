package com.example.project.services;
import com.example.project.models.EmployeeTask;
import com.example.project.models.RegisterDetails;
import com.example.project.repository.EmployeeTaskRepository;
import com.example.project.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeTaskService {

    @Autowired
    private EmployeeTaskRepository taskRepository;

    @Autowired
    private RegisterDetailsRepository registerRepo;

    public String createTask(int employeeId, EmployeeTask task) {
        RegisterDetails employee = registerRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        task.setEmployee(employee);
        EmployeeTask savedTask = taskRepository.save(task);
//        employee.getTasks().add(savedTask);
        registerRepo.save(employee);

        return "Task is created";
    }

}