package com.example.project.repository;
import com.example.project.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findByEmployeeEmpID(int empID);
}