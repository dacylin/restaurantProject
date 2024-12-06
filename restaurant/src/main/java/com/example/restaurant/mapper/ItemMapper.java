package com.example.restaurant.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restaurant.model.Item;

@Mapper
public interface ItemMapper extends BaseMapper<Item>{
    
}
