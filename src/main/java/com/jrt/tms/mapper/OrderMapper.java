package com.jrt.tms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jrt.tms.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}