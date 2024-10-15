package com.serenat.company.foodorderingsystem.service;

import java.util.HashSet;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.serenat.company.foodorderingsystem.manager.PermissionManager;
import com.serenat.company.foodorderingsystem.model.Admin;
import com.serenat.company.foodorderingsystem.model.Permission;
import com.serenat.company.foodorderingsystem.model.constants.AdminType;

import com.serenat.company.foodorderingsystem.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PermissionManager permissionManager;


    public void createAdmin(Long userId, AdminType adminType) {

        Admin newAdmin = new Admin(userId, adminType); 
        newAdmin.setPermissions(permissionManager.getDefaultAdminPermissionsByRole(adminType));
        adminRepository.save(newAdmin);
    }

    public void addPermissionToAdmin(Admin admin, Permission permission) {

        HashSet<Permission> admin_permissions = admin.getPermissions();

        if(admin_permissions == null) {
            admin_permissions = new HashSet<>();
        }

        if(!admin_permissions.contains(permission)) {
            admin_permissions.add(permission);
            adminRepository.save(admin);
        }
    }


    public void removePermissionFromAdmin(Admin admin, Permission permission) {

        HashSet<Permission> admin_permissions = admin.getPermissions();
        
        if(permission != null && admin_permissions.contains(permission)) {
            admin_permissions.remove(permission);
            adminRepository.save(admin);
        }
    }

    public HashSet<Permission> listAllPermissionsOfAdmin(Long id) {

        Admin admin = adminRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Admin not found by id : " + id));
        return admin.getPermissions();
        
    }

    public Admin findAdminById(Long id) {

        Optional<Admin> admin = adminRepository.findById(id);

        if(admin.isPresent()) {
            return admin.get();
        }
        else {
            throw new RuntimeException("Admin not with ID: " + id);
        }
    }
 
    public Admin saveAdmin(Admin admin) {

        return adminRepository.save(admin);
    }

    public String deleteAdminById(Admin admin) {

        adminRepository.deleteById(admin.getAdminId());
        return "Admin user is deleted successfully";
        
    }

}
