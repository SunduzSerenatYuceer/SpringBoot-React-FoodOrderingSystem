package com.serenat.company.foodorderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenat.company.foodorderingsystem.dto.UserRegistrationDto;
import com.serenat.company.foodorderingsystem.model.User;
import com.serenat.company.foodorderingsystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService clientService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto userDto) {

        User user = clientService.registerUser(userDto);
        return ResponseEntity.status(201).body(user);
    }
}
