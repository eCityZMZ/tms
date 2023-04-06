package com.jrt.tms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jrt.tms.entity.ShoppingCart;
import com.jrt.tms.mapper.ShoppingCartMapper;
import com.jrt.tms.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
