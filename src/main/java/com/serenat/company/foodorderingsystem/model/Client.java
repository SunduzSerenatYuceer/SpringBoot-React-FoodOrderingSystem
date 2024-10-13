package com.serenat.company.foodorderingsystem.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.xml.crypto.OctetStreamData;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.aggregation.SetOperators.SetIntersection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import com.serenat.company.foodorderingsystem.model.constants.UserRole;
import jakarta.annotation.Generated;
import java.util.UUID;



@Document(collection = "clients")
public class Client {

    @Id
    private Long clientId;
    
    private HashMap<String, Address> addresses = new HashMap<>();

    private HashSet<Order> orders = new HashSet<>();

    private HashSet<Coupon> coupons = new HashSet<>();

    private HashSet<Store> favorite_stores = new HashSet<>();

    @NonNull
    private String basketId;

    private final UserRole userRole;
    


    public Client(Long clientId) {
        this.clientId = clientId;
        this.basketId = generateBasketId();
        this.userRole = UserRole.CLIENT;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public Address getAddresses(String title) {
        return this.addresses.get(title);
    }

    public String addAddress(Address address) {

        this.addresses.put(address.getTitle(), address);
        return "New address is added successsfully.";
    }

    public String deleteAddress(Address address) {

        this.addresses.remove(address.getTitle());
        return "Address is deleted successfully.";
    }

    public HashSet<Order> getOrders() {

        return this.orders;
    }

    public String addOrder(Order order) {

        this.orders.add(order);
        return "New order is added successfully.";
    }

    public String deleteOrder(Order order) {

        this.orders.remove(order);        
        return "Order is deleted successfully.";
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    private String generateBasketId() {
        return UUID.randomUUID().toString();
    }

    private String getBasketId() {
        return this.basketId;
    }

}


