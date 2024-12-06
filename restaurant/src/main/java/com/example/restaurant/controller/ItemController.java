package com.example.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurant.model.Item;
import com.example.restaurant.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService  itemService;

    @GetMapping
    public List<Item> getAllItem(){
            return itemService.list();
    }


  
}