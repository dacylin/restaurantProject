package com.example.restaurant.controller;

import com.example.restaurant.dto.BillRequest;
import com.example.restaurant.model.Bill;
import com.example.restaurant.model.Order;
import com.example.restaurant.service.BillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/bills")
@Tag(name = "Bill API", description = "This API manages bills and orders in the restaurant")
public class BillController {

    @Autowired
    private BillService billService;

    @Operation(summary = "Create a new bill", description = "This API is used to create a new bill with associated orders")
    @PostMapping
    public String createBill(@RequestBody BillRequest billRequest) {
        Bill bill=billRequest.getBill();
        List<Order> orders=billRequest.getOrders();
        billService.createBill(bill, orders);
        return "Bill created successfully!";
    }

    @Operation(summary = "Get bill details", description = "This API retrieves the details of a specific bill, including its orders and total price")
    @GetMapping("/{billId}/check")
    public Map<String, Object> getBillDetails(@PathVariable Long billId) {
        return billService.getBillDetails(billId);
    }
}

