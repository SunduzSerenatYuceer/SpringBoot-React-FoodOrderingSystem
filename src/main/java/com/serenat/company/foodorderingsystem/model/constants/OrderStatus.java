package com.serenat.company.foodorderingsystem.model.constants;

public enum OrderStatus {

    PENDING,
    ACCEPTED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELED_BY_CLIENT,
    CANCELED_BY_SORE,
    REJECTED_BY_STORE,
    FAIL,
    REFUNDED;
}
