package com.example.Intern.repository;
import com.example.Intern.models.Task;
import com.example.Intern.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByEmployee(RegisterDetails employee);
}
