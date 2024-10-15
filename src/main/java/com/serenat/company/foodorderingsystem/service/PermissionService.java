package com.serenat.company.foodorderingsystem.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.serenat.company.foodorderingsystem.factory.PermissionFactory;
import com.serenat.company.foodorderingsystem.model.Permission;
import com.serenat.company.foodorderingsystem.repository.PermissionRepository;

import jakarta.annotation.PostConstruct;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    private static final HashSet<Permission> ADMIN_PERMISSIONS = new HashSet<>(){{
        add(PermissionFactory.createManageUsersPermission());
        add(PermissionFactory.createManageAdminsPermission());
        add(PermissionFactory.createManageStoresPermission());
        add(PermissionFactory.createManageOrdersPermission());
        add(PermissionFactory.createManageItemsPermission());
        add(PermissionFactory.createManagePaymentsPermission());
        add(PermissionFactory.createManageSystemSettingsPermission());
        add(PermissionFactory.createViewReportsPermission());
        add(PermissionFactory.createViewOrdersPermission());
        add(PermissionFactory.createViewFinancialReportsPermission());
        add(PermissionFactory.createModerateContentsPermission());
        add(PermissionFactory.createViewInvoices());
        add(PermissionFactory.createManageRefundsPermission());

    }};


    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }
    
    public Permission findPermissionById(String name) {
        Optional<Permission> permission = permissionRepository.findById(name);

        if(permission.isPresent()) {
            return permission.get();
        }
        else{
            throw new ResourceNotFoundException("Permission not found with ID: " + name);
        }
    }

    public String deletePermissionById(String name) {

        Permission existingPermission = findPermissionById(name);
        permissionRepository.delete(existingPermission);
        return "Permission is deleted succeessfully.";
    }
 
    @PostConstruct
    public void initializePermissions() {
        
        for(Permission permission : ADMIN_PERMISSIONS) {

            if(!permissionRepository.existsById(permission.getName())) {
                permissionRepository.save(permission);   
            }
        }
    }

    public HashSet<Permission> getAllPermissions() {
        return new HashSet<>(permissionRepository.findAll());
    }

}
