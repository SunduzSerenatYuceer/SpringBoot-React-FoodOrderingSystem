package com.serenat.company.foodorderingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.serenat.company.foodorderingsystem.model.Admin;
import com.serenat.company.foodorderingsystem.model.constants.AdminType;

import com.serenat.company.foodorderingsystem.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public void createAdmin(Long userId, AdminType adminType) {

        Admin newAdmin = new Admin(userId, adminType, null);  //Todo
        adminRepository.save(newAdmin);
    }

}
