package com.serenat.company.foodorderingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.serenat.company.foodorderingsystem.model.Client;


public interface ClientRepository extends MongoRepository<Client, Long>{

}
