package com.example.restaurant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("items")
public class Item {
    @TableId(type = IdType.AUTO)
    private Long itemId;
    private String name;
    private String description;
    private String image;
    private Integer price;
}
