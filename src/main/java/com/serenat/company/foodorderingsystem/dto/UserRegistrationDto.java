package com.serenat.company.foodorderingsystem.dto;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.serenat.company.foodorderingsystem.model.constants.AdminType;
import com.serenat.company.foodorderingsystem.model.constants.UserRole;

public class UserRegistrationDto {

    @NonNull    
    private String username;
    @NonNull    
    private String plainPassword;
    @NonNull    
    private String name;
    @NonNull    
    private String surname;
    @NonNull    
    private String mail;
    @NonNull    
    private String telNumber;
    @NonNull
    private UserRole role;
    @Nullable
    private AdminType adminType;


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username ) {
        this.username = username;
    }

    public String getPlainPassword() {
        return this.plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }


}
