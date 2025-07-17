package com.example.project.repository;
import com.example.project.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {

    RegisterDetails findByEmail(String email);


    RegisterDetails findByUserName(String userName);
}