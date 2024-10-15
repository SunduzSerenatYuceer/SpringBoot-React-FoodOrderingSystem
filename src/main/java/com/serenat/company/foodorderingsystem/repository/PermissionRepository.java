package com.serenat.company.foodorderingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.serenat.company.foodorderingsystem.model.Permission;

public interface PermissionRepository extends MongoRepository<Permission, String> {

}
