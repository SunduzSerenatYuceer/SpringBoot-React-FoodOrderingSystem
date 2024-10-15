package com.serenat.company.foodorderingsystem.model;

import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.serenat.company.foodorderingsystem.model.constants.AdminType;
import com.serenat.company.foodorderingsystem.model.constants.UserRole;
import com.serenat.company.foodorderingsystem.model.constants.UserStatus;

import jakarta.annotation.Nonnull;

@Document(collection = "admins")
public class Admin {

    @Id
    private Long adminId;

    @Nonnull
    private UserRole userRole;

    @Nonnull
    private AdminType adminType;

    @Nonnull
    private UserStatus adminStatus;

    @Nonnull
    private HashSet<Permission> permissions;


    public Admin(Long adminId, AdminType adminType) {
        this.adminId = adminId;
        this.userRole = UserRole.ADMIN;
        this.adminStatus = UserStatus.ACTIVE;
        this.adminType = adminType;
    }


    public Long getAdminId() {
        return adminId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public UserStatus getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(UserStatus adminStatus) {
        this.adminStatus = adminStatus;
    }

    public HashSet<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(HashSet<Permission> permissions ) {
        this.permissions = permissions;
    }


}
