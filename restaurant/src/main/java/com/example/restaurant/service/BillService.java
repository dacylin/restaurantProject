package com.example.restaurant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.restaurant.mapper.BillMapper;
import com.example.restaurant.mapper.OrderMapper;
import com.example.restaurant.mapper.BillOrderMapper;
import com.example.restaurant.mapper.MenuMapper;
import com.example.restaurant.model.Bill;
import com.example.restaurant.model.Order;
import com.example.restaurant.model.BillOrder;
import com.example.restaurant.model.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BillService extends ServiceImpl<BillMapper, Bill> {

    @Autowired
    BillMapper billMapper;
    
    @Autowired
    OrderMapper orderMapper;
    
    @Autowired
    BillOrderMapper billOrderMapper;

    @Autowired
    MenuMapper menuMapper;

    public boolean createBill(Bill bill, List<Order> orders) {
       
        boolean isBillSaved = billMapper.insert(bill) > 0;
        if (!isBillSaved) {
            throw new RuntimeException("Failed to create bill.");
        }
        
        for (Order order : orders) {

            Menu menu = menuMapper.selectById(order.getItemId());

            if (menu == null) {
                throw new IllegalArgumentException("Menu item not found for itemId: " + order.getItemId());
            }

            order.setOrderTime(LocalDateTime.now());
            orderMapper.insert(order);  
            
            BillOrder billOrder = new BillOrder();
            billOrder.setBillId(bill.getBillId());
            billOrder.setOrderId(order.getOrderId());
            billOrderMapper.insert(billOrder);  
        }

        return true;
    }

    
    public Map<String, Object> getBillDetails(Long billId) {
        List<Order> orders = orderMapper.getOrderByBillId(billId);
        List<Map<String, Object>> orderDetails = new ArrayList<>();
        double totalPrice = 0;

        for (Order order : orders) {
            
            Menu menu = menuMapper.selectById(order.getItemId());

            if (menu == null) {
                throw new IllegalArgumentException("Menu item not found for itemId: " + order.getItemId());
            }

            double itemTotal = menu.getPrice() * order.getQuantity();
            totalPrice += itemTotal;

            Map<String, Object> detail = new HashMap<>();
            detail.put("menu", menu);
            detail.put("quantity", order.getQuantity());
            detail.put("totalPrice", itemTotal);
            orderDetails.add(detail);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("orders", orderDetails);
        result.put("totalPrice", totalPrice);
        return result;
    }
}


