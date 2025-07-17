package com.example.project.services;
import com.example.project.models.RegisterDetails;
import com.example.project.repository.RegisterDetailsRepository;
import com.example.project.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        RegisterDetails user = registerDetailsRepo.findByUserName(username);

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleName()))
                .collect(Collectors.toSet());

        System.out.println("username is" + user.getUserName() + "\npassword is " + user.getPassword() + "\nAu" + authorities);

        return new User(user.getUserName(), user.getPassword(), authorities);
    }
}