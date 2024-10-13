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


    public Admin(Long adminId, AdminType adminType, HashSet<Permission> permissions) {
        this.adminId = adminId;
        this.userRole = UserRole.ADMIN;
        this.adminStatus = UserStatus.ACTIVE;
        this.adminType = adminType;
        this.permissions = permissions;
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

    public String addPermission(Permission permission) {
        this.permissions.add(permission);
        return "New permission is added successfully.";
    }

    public String removePermission(Permission permission) {
        this.permissions.remove(permission);
        return "Permision is removed successfully.";
    }

    public String listAllPermissionsWithDescriptions() {
        // Todo
        return "";
    }

}
