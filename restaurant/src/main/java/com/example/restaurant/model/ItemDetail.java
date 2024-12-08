package com.example.restaurant.model;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("item_detail")
public class ItemDetail {
    private Long itemId;   
    private Long detailId; 
}
