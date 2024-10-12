package com.serenat.company.foodorderingsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.serenat.company.foodorderingsystem.model.constants.AddressType;

@Document(collection = "addresses")
public class Address {

    @NonNull
    private Long userId;

    @Id
    private String title;

    @NonNull
    private String city;

    @NonNull
    private String country;

    @NonNull
    private String neighboor; 

    @NonNull
    private String street;

    @NonNull
    private String aptNo;

    @Nullable
    private String floor;

    @Nullable
    private String suiteNo;

    @NonNull
    private String addressDescription;

    @NonNull
    private AddressType addressType;


    public Address(Long userId, String title, String city, String country, String neighboor, String street, String aptNo, String floor, String suiteNo, AddressType addressType) {
 
        this.userId = userId;
        this.title = title;
        this.city = city;
        this.country = country;
        this.neighboor = neighboor;
        this.street = street;
        this.aptNo = aptNo;
        this.floor = floor;
        this.suiteNo = suiteNo; 
        this.addressType = addressType;     
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNeighboor() {
        return this.neighboor;
    }

    public void setNeighboor(String neighboor) {
        this.neighboor = neighboor;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAptNo() {
        return this.aptNo;
    }

    public void setAptNo(String aptNo) {
        this.aptNo = aptNo;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSuiteNo() {
        return this.suiteNo;
    }

    public void setSuiteNo(String suiteNo) {
        this.suiteNo = suiteNo;
    }

    public String getAddressDescription() {
        return this.addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

}
