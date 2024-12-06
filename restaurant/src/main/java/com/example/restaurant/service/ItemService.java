package com.example.restaurant.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.restaurant.mapper.ItemMapper;
import com.example.restaurant.model.Item;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> {
}
