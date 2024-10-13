package com.serenat.company.foodorderingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.serenat.company.foodorderingsystem.model.Store;
import com.serenat.company.foodorderingsystem.repository.StoreRepository;


@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    public void createStore(Long userId) {

        Store newStore = new Store(userId);
        storeRepository.save(newStore);

    }

}
