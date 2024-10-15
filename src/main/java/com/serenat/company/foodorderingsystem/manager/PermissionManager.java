package com.serenat.company.foodorderingsystem.manager;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serenat.company.foodorderingsystem.factory.PermissionFactory;
import com.serenat.company.foodorderingsystem.model.Admin;
import com.serenat.company.foodorderingsystem.model.Permission;
import com.serenat.company.foodorderingsystem.model.constants.AdminType;
import com.serenat.company.foodorderingsystem.service.AdminService;
import com.serenat.company.foodorderingsystem.service.PermissionService;


@Component
public class PermissionManager {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private AdminService adminService;

    private HashSet<Permission> AdminPermissions = new HashSet<>() {{
        add(PermissionFactory.createManageUsersPermission());
        add(PermissionFactory.createManageOrdersPermission());
        add(PermissionFactory.createManageStoresPermission());
        add(PermissionFactory.createManageItemsPermission());
        add(PermissionFactory.createViewReportsPermission());
    }};

    private HashSet<Permission> ModeratorPermissions = new HashSet<>() {{
        add(PermissionFactory.createViewOrdersPermission());
        add(PermissionFactory.createModerateContentsPermission());
    }};

    private HashSet<Permission> StoreAdminPermissions = new HashSet<>() {{
        add(PermissionFactory.createManageStoresPermission());
        add(PermissionFactory.createManageItemsPermission());
        add(PermissionFactory.createViewOrdersPermission());
    }};

    private HashSet<Permission> FinanceAdminPermissions = new HashSet<>() {{
        add(PermissionFactory.createManagePaymentsPermission());
        add(PermissionFactory.createManageRefundsPermission());
        add(PermissionFactory.createViewFinancialReportsPermission());
        add(PermissionFactory.createViewInvoices());
    }};


    public void addMultiplePermissionsToAdmin(Admin admin, HashSet<Permission> permissions) {

        HashSet<Permission> admin_permissions = admin.getPermissions();

        for (Permission permission : permissions) {

            if(!admin_permissions.contains(permission)) {
                adminService.addPermissionToAdmin(admin, permission);
            }
        }
        
    }

    public void removeMultiplePermissionsToAdmin(Admin admin, HashSet<Permission> permissions) {

        HashSet<Permission> admin_perminssions = admin.getPermissions();

        for(Permission permission : permissions) {

            if(admin_perminssions.contains(permission)) {
                adminService.removePermissionFromAdmin(admin, permission);
            }

        }        

    }

    public HashSet<Permission> getDefaultAdminPermissionsByRole(AdminType role) {

        switch(role) {
            case SUPER_ADMIN:
                return permissionService.getAllPermissions();
            
            case ADMIN:
                return AdminPermissions;

            case MODERATOR:
                return ModeratorPermissions;

            case STORE_ADMIN:
                return StoreAdminPermissions;
            
            case FINANCE_ADMIN:
                return FinanceAdminPermissions;

            default:
                break;
        }

        return null;

    }

}
