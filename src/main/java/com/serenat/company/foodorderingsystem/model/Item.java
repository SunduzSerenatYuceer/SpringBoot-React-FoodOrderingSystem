package com.serenat.company.foodorderingsystem.model;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import com.mongodb.lang.NonNull;

public class Item {

    @Id
    private String itemId;

    @NonNull
    private String name;

    @NonNull
    private Float unit_price;

    @NonNull
    private Float total_price;

    @NonNull
    private int quantity;


    public Item(String name, Float unit_price, int quantity) {

        this.itemId = generateItemId();
        this.name = name;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.total_price = unit_price * quantity;
    }


    public String generateItemId() {
        return UUID.randomUUID().toString();
    }

    public  String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitPrice() {
        return this.unit_price;
    }

    public void setUnitPrice(Float unit_price) {
        this.unit_price = unit_price;
    }

    public Float getTotalPrice() {
        return this.total_price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



}
