package com.serenat.company.foodorderingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.serenat.company.foodorderingsystem.model.Store;


public interface StoreRepository extends MongoRepository<Store, String> {

}
