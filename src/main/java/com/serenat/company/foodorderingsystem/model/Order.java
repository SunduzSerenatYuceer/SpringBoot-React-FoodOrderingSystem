package com.serenat.company.foodorderingsystem.model;

import java.util.HashMap;
import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import com.serenat.company.foodorderingsystem.model.constants.OrderStatus;
import com.serenat.company.foodorderingsystem.model.constants.PaymentMethod;


@Document(collection = "orders")
public class Order {

    private String clientId;
    private String orderId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private String order_note;
    private String storeId;
    private PaymentMethod payment_method;
    private Double total_price;
    private Address delivery_address;
    private Float delivery_fee;
    private String delivery_person_id;
    private LocalDateTime estimated_delivery_time;
    private String discount; // discount or coupon
    private HashMap<Item, Integer> items = new HashMap<>();

    private LocalDateTime currentDate = LocalDateTime.now();


    public Order(String clientId, String orderId, String storeId, String order_note, PaymentMethod payment_method, Address delivery_address, Float delivery_fee, String discount, String delivery_person_id, LocalDateTime estimated_delivery_time, HashMap<Item, Integer> items){
        this.clientId = clientId;
        this.orderId = orderId;
        this.orderDate = currentDate;
        this.orderStatus = OrderStatus.PENDING;
        this.order_note = order_note;
        this.storeId = storeId;
        this.payment_method = payment_method;
        this.delivery_address = delivery_address;
        this.delivery_fee = delivery_fee;  // This can be changed!!
        this.delivery_person_id = delivery_person_id;
        this.estimated_delivery_time = estimated_delivery_time; // This can be changed !!
        this.discount = discount;
        this.items = items;
        this.total_price = calculateTotalPrice(this.items);

    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNote() {
        return order_note;
    }

    public PaymentMethod getPaymentMethod() {
        return this.payment_method;
    }

    public  Double getTotalPrice() {
        return total_price;
    }

    public Double calculateTotalPrice(HashMap<Item, Integer> items) {
        // Todo
        return 7777.7;
    }

    public Address getDeliveryAddress() {
        return delivery_address;
    }

    public void setDeliveryAddress(Address delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Float getDeliveryFee() {
        return delivery_fee;
    }

    public void setDeliveryFee(Float delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getDeliveryPersonId() {
        return delivery_person_id;
    }

    public void setDeliveryPersonId(String delivery_person_id) {
        this.delivery_person_id = delivery_person_id;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimated_delivery_time;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimated_delivery_time) {
        this.estimated_delivery_time = estimated_delivery_time;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }









}
