package com.serenat.company.foodorderingsystem.model;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "baskets")
public class Basket {

    @Id
    private String basketId;

    @NonNull
    private Long clientId;

    private HashSet<Item> items;

    private Double totalPrice;

    @NonNull
    private LocalDate updatedDate;


    public Basket(String basketId, Long clientId) {
        this.basketId = basketId;
        this.clientId = clientId;
        this.updatedDate  = LocalDate.now();
    }


    public String getBasketId() {
        return basketId;
    }

    public Long getClientId() {
        return clientId;
    }

    public HashSet<Item> getItems() {
        return items;
    }

    public void setItems(HashSet<Item> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }






}
