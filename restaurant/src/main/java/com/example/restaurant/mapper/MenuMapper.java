package com.example.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restaurant.model.Menu;

@Mapper
public interface MenuMapper extends BaseMapper<Menu>{

    @Select("SELECT * FROM items WHERE name LIKE CONCAT('%', #{keyword}, '%') OR description LIKE CONCAT('%', #{keyword}, '%')")
    List<Menu> searchByKeyword(String keyword);
    
}
