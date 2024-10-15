package com.serenat.company.foodorderingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.serenat.company.foodorderingsystem.model.Admin;


public interface AdminRepository extends MongoRepository<Admin, Long> {

}
