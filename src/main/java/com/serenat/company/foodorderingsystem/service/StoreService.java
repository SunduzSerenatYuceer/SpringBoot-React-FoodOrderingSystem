package com.serenat.company.foodorderingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.serenat.company.foodorderingsystem.model.Coordinate;
import com.serenat.company.foodorderingsystem.model.Store;
import com.serenat.company.foodorderingsystem.model.constants.DeliveryOptions;
import com.serenat.company.foodorderingsystem.repository.StoreRepository;


@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;


    public void createStore(Long userId) {

        Store newStore = new Store(userId);
        storeRepository.save(newStore);
    }

    public Store findStoreById(Long userId) {

        Optional<Store> store = storeRepository.findById(userId);
        
        if(store.isPresent()) {
            return store.get();
        }
        else {
            throw new ResourceNotFoundException("Store not found with Id : " + userId);
        }      
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public List<Store> getStoresByDeliveryOptions(DeliveryOptions options) {
        return storeRepository.findByDeliveryOptionsContaining(options);
    }

    public List<Store> getStoresByDistance(Coordinate coordinate, Double maxDistance) {
        return storeRepository.findStoresWithinDistance(coordinate.getLatitude(), coordinate.getLongitude(), maxDistance);
    }

    public List<Store> getStoresByRating(Double minRating) {
        return storeRepository.findByRatingGreaterThanEqual(minRating);
    }

    public Long getTotalStores() {
        return storeRepository.count();
    }

    public List<Store> searchStores(String query) {
        return storeRepository.searchByNameContaining(query);
    }

    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    public String deleteStoreById(Long userId) {

        Store store = findStoreById(userId);
        storeRepository.delete(store);
        return "Store is deleted successfully.";
    }




}
