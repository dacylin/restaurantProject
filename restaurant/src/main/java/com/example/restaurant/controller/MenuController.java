package com.example.restaurant.controller;

import com.example.restaurant.model.Menu;
import com.example.restaurant.service.MenuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@Tag(name = "Menu API", description = "This API manages menu items in the restaurant")
public class MenuController {

    @Autowired
    private MenuService menuService;

   
    @Operation(summary = "Create a new menu item", description = "This API is used to create a new menu item")
    @PostMapping
    public String createMenu(@RequestBody Menu menu) {
        menuService.createMenu(menu);
        return "Menu item created successfully!";
    }
    
    @Operation(summary = "Get list of menu items", description = "This API fetches the list of menu items with pagination and optional search")
    @GetMapping
    public List<Menu> getMenus(@RequestParam int page,
                            @RequestParam int size,
                            @RequestParam(required = false, defaultValue = "") String keyword){
        return menuService.getMenus(page, size, keyword).getRecords();  
    }

    @Operation(summary = "Update a menu item", description = "This API updates an existing menu item based on the provided item ID")
    @PutMapping("/{itemId}")
    public String updateMenu(@PathVariable Long itemId,
                            @RequestBody Menu menu) {
        menu.setItemId(itemId);
        menuService.updateMenu(menu);
        return "Menu item updated successfully!";
    }


    @Operation(summary = "Delete a menu item", description = "This API deletes a specific menu item by its ID")
    @DeleteMapping("/{itemId}")
    public String deleteMenu(@PathVariable Long itemId) {
        menuService.deleteMenu(itemId);
        return "Menu item deleted successfully!";
    }
}

