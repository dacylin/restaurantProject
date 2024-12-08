package com.example.restaurant.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("details")
public class Details {
    @TableId(type = IdType.AUTO)
    private Long detailId;  
    private String title;   
}
