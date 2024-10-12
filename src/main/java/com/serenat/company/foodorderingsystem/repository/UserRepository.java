package com.serenat.company.foodorderingsystem.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.serenat.company.foodorderingsystem.model.User;

public interface UserRepository extends MongoRepository<User, Long>{

    Optional<User> findByUsername(String username);

}
