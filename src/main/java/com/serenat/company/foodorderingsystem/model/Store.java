package com.serenat.company.foodorderingsystem.model;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.serenat.company.foodorderingsystem.model.constants.DeliveryOptions;
import com.serenat.company.foodorderingsystem.model.constants.UserStatus;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

@Document(collection = "stores")
public class Store {

    @Id
    private Long storeId;

    @NonNull
    private UserStatus storeStatus;

    @Nonnull
    private String storeName;

    @Nullable
    private String storeDescription;

    @NonNull
    private Address address;

    @NonNull
    private Coordinate coordinates;

    @Nonnull
    private String contactNumber;  

    @Nullable
    private String storeMail;  // if store's owner mail and store mail are different from each other.

    @Nonnull
    private String openingHours;

    @Nonnull
    private HashSet<Item> menu;

    @Nonnull
    private double rating;

    @Nonnull
    private HashSet<DeliveryOptions> deliveryOptions;

    @Nullable
    private String imageUrl;

    @Nonnull
    private LocalDate createdDate;

    @Nonnull
    private LocalDate lastUpdatedDate;



    public Store(Long storeId) {
        this.storeId = storeId;
        this.storeStatus  = UserStatus.ACTIVE;
        this.createdDate = LocalDate.now();
    }

    public Long getStoreId() {
        return storeId;
    }

    public UserStatus getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(UserStatus storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDescription() {
        return storeDescription;
    }

    public void setStoreDescription(String storeDescription) {
        this.storeDescription = storeDescription;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getStoreMail() {
        return storeMail;
    }

    public void setStoreMail(String storeMail) {
        this.storeMail = storeMail;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public HashSet<Item> getMenu() {
        return menu;
    }

    public void setMenu(HashSet<Item> menu) {
        this.menu = menu;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public HashSet<DeliveryOptions> getDeliveryOptions() {
        return deliveryOptions;
    }

    public void setDeliveryOptions(HashSet<DeliveryOptions> deliveryOptions) {
        this.deliveryOptions = deliveryOptions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
