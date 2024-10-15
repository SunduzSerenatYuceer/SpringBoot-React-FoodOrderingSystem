package com.serenat.company.foodorderingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serenat.company.foodorderingsystem.model.Coordinate;
import com.serenat.company.foodorderingsystem.model.Store;
import com.serenat.company.foodorderingsystem.model.constants.DeliveryOptions;
import com.serenat.company.foodorderingsystem.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    StoreService storeService;


    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {

        List<Store> stores = storeService.getAllStores();
        return ResponseEntity.ok(stores);
        
    }


    @DeleteMapping("/{storeId}")
    public ResponseEntity<Void> deleteStoreById(@PathVariable Long storeId) {

        storeService.deleteStoreById(storeId);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long storeId) {

        Store store = storeService.findStoreById(storeId);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/delivery-option")
    public ResponseEntity<List<Store>> getStoresByDeliveryOptions(@PathVariable String option) {

        try {
            DeliveryOptions deliveryOption = DeliveryOptions.valueOf(option.toUpperCase());
            List<Store> stores = storeService.getStoresByDeliveryOptions(deliveryOption);
            return ResponseEntity.ok(stores);
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @GetMapping("/distance")
    public ResponseEntity<List<Store>> getStoresByDistance(@RequestParam Double Latitude, @RequestParam Double Longitude, @RequestParam Double maxDistance) {
        Coordinate coordinate = new Coordinate(Latitude, Longitude);
        List<Store> stores = storeService.getStoresByDistance(coordinate, maxDistance);
        return ResponseEntity.ok(stores);
    }

    @GetMapping("/rating/{minRating}")
    public ResponseEntity<List<Store>> getStoresByRating(@RequestParam Double minRating) {
        List<Store> stores = storeService.getStoresByRating(minRating);
        return ResponseEntity.ok(stores);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTotalStores() {
        Long count = storeService.getTotalStores();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Store>> searchStores(@RequestParam String query) {
        List<Store> stores = storeService.searchStores(query);
        return ResponseEntity.ok(stores);
    }

}
