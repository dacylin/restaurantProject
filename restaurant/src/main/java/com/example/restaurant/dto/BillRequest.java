package com.example.restaurant.dto;

import com.example.restaurant.model.Bill;
import com.example.restaurant.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class BillRequest {
    private Bill bill;
    private List<Order> orders;
}
