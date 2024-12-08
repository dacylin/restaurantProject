package com.example.restaurant.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restaurant.model.Bill;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {
}
