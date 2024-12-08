package com.example.restaurant.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("bill_order")
public class BillOrder {
    @TableField("bill_id")
    private Long billId; 
    
    @TableField("order_id")
    private Long orderId; 
}
