package com.example.task.controllers;

import com.example.task.models.RegisterDetails;
import com.example.task.models.UserDetailsDto;
import com.example.task.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserDetailsDto register){
        return authService.addNewEmployee(register);
    }

    @PostMapping("/login")
    public String Login(@RequestBody RegisterDetails login){
        return authService.authenticateAndGenerateToken(login.getName(), login.getPassword());
    }

}
