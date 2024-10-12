package com.serenat.company.foodorderingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serenat.company.foodorderingsystem.dto.UserRegistrationDto;
import com.serenat.company.foodorderingsystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService clientService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationDto userDto) {

        clientService.registerUser(userDto);
        return "User registered successfully.";
    }
}
