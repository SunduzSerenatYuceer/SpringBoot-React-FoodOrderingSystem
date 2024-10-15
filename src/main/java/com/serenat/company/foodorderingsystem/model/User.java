package com.serenat.company.foodorderingsystem.model;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.serenat.company.foodorderingsystem.model.constants.AdminType;
import com.serenat.company.foodorderingsystem.model.constants.UserRole;



@Document(collection = "users")
public class User {

    public static final String SEQUENCE_NAME = "user_sequence";


    @Id
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    @Indexed(unique = true)
    private String mail;

    @JsonIgnore
    private String hashedPassword;

    @NonNull
    private UserRole role;

    @Nullable
    private AdminType adminType;


    public User(Long id, String username, String hashPassword, String mail, UserRole role, String name, String surname, AdminType adminRole) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.hashedPassword = hashPassword;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.adminType = (role != UserRole.ADMIN) ? null : adminRole;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    
    public UserRole getRole(){
        return this.role;
    }

    public void setRole(UserRole role){
        this.role = role;
    }

    public AdminType getAdminType() {
        return adminType;
    }

    public void setAdminType(AdminType adminType) {
        this.adminType = adminType;
    }


    



}

