package com.example.Intern.controllers;
import com.example.Intern.models.RegisterDetails;
import com.example.Intern.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegisterDetailsRepository userRepository;
    @PostMapping("/add")
    public RegisterDetails addUser(@RequestBody RegisterDetails user) {
        return userRepository.save(user);
    }
    @GetMapping("/all")
    public List<RegisterDetails> getAllUsers() {
        return userRepository.findAll();
    }
}
