package com.serenat.company.foodorderingsystem.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

        if (permissionRepository.existsById(permission.getName())) {
            throw new IllegalArgumentException("Permission with this name alread");
        }

        return permissionRepository.save(permission);
    }
    
    public Optional<Permission> findPermissionByName(String name) {
        return permissionRepository.findById(name);
    }

    public void deletePermissionByName(String name) {
        permissionRepository.deleteById(name);
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
