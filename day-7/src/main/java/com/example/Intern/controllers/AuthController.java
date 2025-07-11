package com.example.Intern.controllers;
import com.example.Intern.models.RegisterDetails;
import com.example.Intern.models.UserDetailsDto;
import com.example.Intern.services.AuthService;
import com.example.Intern.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register){
        return authService.addNewEmployee(register);
    }
    @PostMapping("/login")
    public String Login(@RequestBody RegisterDetails login){
        return authService.authenticate(login);
    }
}
