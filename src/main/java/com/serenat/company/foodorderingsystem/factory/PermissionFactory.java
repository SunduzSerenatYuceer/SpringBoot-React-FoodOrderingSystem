package com.serenat.company.foodorderingsystem.factory;

import com.serenat.company.foodorderingsystem.model.Permission;
import com.serenat.company.foodorderingsystem.model.constants.PermissionConstants;

public class PermissionFactory {


    public static Permission createManageUsersPermission() {
        return new Permission(PermissionConstants.MANAGE_USERS, PermissionConstants.MANAGE_USERS_DESC);
    }

    public static Permission createManageAdminsPermission() {
        return new Permission(PermissionConstants.MANAGE_ADMINS, PermissionConstants.MANAGE_ADMINS_DESC);
    }

    public static Permission createManageStoresPermission() {
        return new Permission(PermissionConstants.MANAGE_STORES, PermissionConstants.MANAGE_STORES_DESC);
    }

    public static Permission createManageOrdersPermission() {
        return new Permission(PermissionConstants.MANAGE_ORDERS, PermissionConstants.MANAGE_ORDERS_DESC);
    }

    public static Permission  createManageItemsPermission() {
        return new Permission(PermissionConstants.MANAGE_ITEMS, PermissionConstants.MANAGE_ITEMS_DESC);
    }

    public static Permission createManageSystemSettingsPermission() {
        return new Permission(PermissionConstants.MANAGE_SYSTEM_SETTINGS, PermissionConstants.MANAGE_SYSTEM_SETTINGS_DESC);
    }

    public static Permission createManagePaymentsPermission() {
        return new Permission(PermissionConstants.MANAGE_PAYMENTS, PermissionConstants.MANAGE_PAYMENTS_DESC);
    }

    public static Permission createViewReportsPermission() {
        return new Permission(PermissionConstants.VIEW_REPORTS, PermissionConstants.VIEW_REPORTS_DESC);
    }

    public static Permission createViewOrdersPermission() {
        return new Permission(PermissionConstants.VIEW_ORDERS, PermissionConstants.VIEW_ORDERS_DESC);
    }

    public static Permission createViewFinancialReportsPermission() {
        return new Permission(PermissionConstants.VIEW_FINANCIAL_REPORTS, PermissionConstants.VIEW_FINANCIAL_REPORTS_DESC);
    }

    public static Permission createModerateContentsPermission() {
        return new Permission(PermissionConstants.MODERATE_CONTENTS, PermissionConstants.MODERATE_CONTENTS_DESC);
    }

    public static Permission createManageRefundsPermission() {
        return new Permission(PermissionConstants.MANAGE_REFUNDS, PermissionConstants.MANAGE_REFUNDS_DESC);
    }

    public static Permission createViewInvoices() {
        return new Permission(PermissionConstants.VIEW_INVOICES, PermissionConstants.VIEW_INVOICES_DESC);
    }


}


