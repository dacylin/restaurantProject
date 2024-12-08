package com.example.restaurant.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restaurant.model.Details;

@Mapper
public interface DetailsMapper extends BaseMapper<Details> {
}

