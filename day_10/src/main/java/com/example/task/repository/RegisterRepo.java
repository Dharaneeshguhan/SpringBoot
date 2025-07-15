package com.example.task.repository;
import com.example.task.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends JpaRepository<RegisterDetails,Integer> {

    Optional<RegisterDetails> findByUserName(String userName);
}
