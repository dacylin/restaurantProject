package com.example.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restaurant.model.Order;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("SELECT o.* " +
            "FROM orders o " +
            "JOIN bill_order bo ON o.order_id = bo.order_id " +
            "WHERE bo.bill_id = #{billId}")
    List<Order> getOrderByBillId(Long billId);

}

