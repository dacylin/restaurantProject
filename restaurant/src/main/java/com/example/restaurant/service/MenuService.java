package com.example.restaurant.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.restaurant.mapper.MenuMapper;
import com.example.restaurant.model.Menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class MenuService extends ServiceImpl<MenuMapper, Menu> {
    
    @Autowired
    MenuMapper menuMapper;

    public boolean createMenu(Menu menu) {
        return menuMapper.insert(menu) > 0;
    }

    public IPage<Menu> getMenus(int page, int size, String keyword ) {
        Page<Menu> menuPage = new Page<>(page, size);

        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", keyword);

        return menuMapper.selectPage(menuPage, queryWrapper);
    }

    public Menu getMenuById(Long itemId) {
        return menuMapper.selectById(itemId);
    }

    public List<Menu> searchMenu(String keyword) {
        return menuMapper.searchByKeyword(keyword);  
    }

    public boolean updateMenu(Menu menu) {
        return menuMapper.updateById(menu) > 0;
    }

    public boolean deleteMenu(Long itemId) {
        return menuMapper.deleteById(itemId) > 0;
    }
}
