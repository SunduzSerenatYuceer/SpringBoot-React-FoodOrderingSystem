package com.serenat.company.foodorderingsystem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.serenat.company.foodorderingsystem.model.Store;
import com.serenat.company.foodorderingsystem.model.constants.DeliveryOptions;


public interface StoreRepository extends MongoRepository<Store, Long> {

    // Query("{ 'deliveryOptions': { $in: ?0 } }"
    // db.store.find({ 'deliveryOptions': { $in: <deliveryOption> } })
    List<Store> findByDeliveryOptionsContaining(DeliveryOptions options);

    // @Query("{ 'location': { $near: { $geometry: { type: 'Point', coordinates: [ ?0, ?1 ] }, $maxDistance: ?2 } } } }")
    // db.store.find({ 'location': { $near: { $geometry: { type: 'Point', coordinates: [longitude, latitude] }, $maxDistance: maxDistance } } } })
    List<Store> findStoresWithinDistance(Double latitude, Double longitude, Double maxDistance);

    // @Query("{ 'rating': { $gte: ?0 } }")
    // db.store.find({ 'rating': { $gte: <rating> } })
    List<Store> findByRatingGreaterThanEqual(Double minRating);

    // @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    // db.store.find({ name: { $regex: query, $options: 'i' } })
    List<Store> searchByNameContaining(String query);


}
