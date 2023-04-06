package com.jrt.tms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jrt.tms.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
