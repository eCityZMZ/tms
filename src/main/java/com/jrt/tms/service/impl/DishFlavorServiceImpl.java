package com.jrt.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrt.tms.entity.DishFlavor;
import com.jrt.tms.mapper.DishFlavorMapper;
import com.jrt.tms.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper,DishFlavor> implements DishFlavorService {
}
